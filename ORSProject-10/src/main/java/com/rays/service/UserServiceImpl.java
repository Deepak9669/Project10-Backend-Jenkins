package com.rays.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.email.EmailBuilder;
import com.rays.email.EmailMessage;
import com.rays.email.EmailServiceInt;

/**
 * Implementation of UserServiceInt interface.
 * 
 * This class provides business logic for User related
 * operations such as registration, authentication,
 * password management, and email notifications.
 * 
 * <p>
 * It extends BaseServiceImpl to inherit common CRUD
 * functionalities and interacts with UserDAOInt for
 * data access operations.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Service} to mark it as a Spring
 * service component.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Transactional} to ensure all
 * operations are executed within a transactional context.
 * </p>
 * 
 * @author 
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

    /**
     * Email service used for sending user-related emails.
     */
    @Autowired
    private EmailServiceInt emailservice;

    /**
     * Finds a user by login ID.
     * 
     * @param login the login ID of the user
     * @param userContext the user context
     * @return UserDTO if found, otherwise null
     */
    @Transactional(readOnly = true)
    public UserDTO findByLoginId(String login, UserContext userContext) {
        return baseDao.findByUniqueKey("loginId", login, userContext);
    }

    /**
     * Registers a new user and sends a registration email.
     * 
     * @param dto the user data transfer object
     * @param userContext the user context
     * @return the registered UserDTO
     */
    @Override
    public UserDTO register(UserDTO dto, UserContext userContext) {
        baseDao.add(dto, userContext);

        HashMap<String, String> map = new HashMap<>();
        map.put("login", dto.getLoginId());
        map.put("password", dto.getPassword());
        map.put("firstName", dto.getFirstName());

        EmailMessage msg = new EmailMessage();
        msg.setTo(dto.getLoginId());
        msg.setSubject("User Registration Successful");
        msg.setMessage(EmailBuilder.getUserRegistrationMessage(map));
        msg.setMessageType(EmailMessage.HTML_MSG);

        emailservice.sendMail(msg);
        return dto;
    }

    /**
     * Authenticates a user based on login ID and password.
     * 
     * @param loginId the login ID
     * @param password the password
     * @return authenticated UserDTO if successful, otherwise null
     */
    @Override
    public UserDTO authenticate(String loginId, String password) {
        UserDTO dto = findByLoginId(loginId, null);

        if (dto != null) {
            UserContext userContext = new UserContext(dto);
            if (password.equals(dto.getPassword())) {
                dto.setLastLogin(new Timestamp((new Date()).getTime()));
                dto.setUnsucessfullLoginAttempt(0);
                update(dto, userContext);
                return dto;
            } else {
                dto.setUnsucessfullLoginAttempt(1 + dto.getUnsucessfullLoginAttempt());
                update(dto, userContext);
            }

        }
        return null;
    }

    /**
     * Handles forgot password functionality and sends password via email.
     * 
     * @param loginId the login ID of the user
     * @return true if email sent successfully, otherwise false
     */
    @Override
    public boolean forgotPassword(String loginId) {

        UserDTO dto = findByLoginId(loginId, null);

        if (dto == null) {
            return false;
        }

        HashMap<String, String> map = new HashMap<>();

        map.put("firstName", dto.getFirstName());
        map.put("lastName", dto.getLastName());
        map.put("login", dto.getLoginId());
        map.put("password", dto.getPassword());

        String message = EmailBuilder.getForgetPasswordMessage(map);

        EmailMessage email = new EmailMessage();

        email.setTo(dto.getLoginId());
        email.setSubject("Your Password has been forgotten.....");
        email.setMessage(message);
        email.setMessageType(EmailMessage.HTML_MSG);

        emailservice.sendMail(email);

        return true;
    }

    /**
     * Changes the password of a user and sends confirmation email.
     * 
     * @param loginId the login ID of the user
     * @param oldPassword the old password
     * @param newPassword the new password
     * @param userContext the user context
     * @return updated UserDTO if successful, otherwise null
     */
    @Override
    public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext) {

        UserDTO dto = findByLoginId(loginId, null);

        dto.setCreatedBy(userContext.getLoginId());

        if (dto != null && oldPassword.equals(dto.getPassword())) {

            dto.setPassword(newPassword);
            update(dto, userContext);

            HashMap<String, String> map = new HashMap<>();

            map.put("firstName", dto.getFirstName());
            map.put("lastName", dto.getLastName());
            map.put("login", dto.getLoginId());
            map.put("password", dto.getPassword());

            String message = EmailBuilder.getChangePasswordMessage(map);

            EmailMessage email = new EmailMessage();
            email.setTo(dto.getLoginId());
            email.setSubject("ORS Password Changed Successfully");
            email.setMessage(message);
            email.setMessageType(EmailMessage.HTML_MSG);

            emailservice.sendMail(email);

            return dto;

        } else {
            return null;
        }
    }
}