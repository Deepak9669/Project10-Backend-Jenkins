package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;

/**
 * Service interface for User operations.
 * 
 * This interface defines business methods for handling
 * User related functionality such as authentication,
 * registration, and password management. It extends
 * BaseServiceInt to inherit standard CRUD operation
 * declarations for UserDTO.
 * 
 * <p>
 * Classes implementing this interface will provide
 * concrete business logic for User related services.
 * </p>
 * 
 * @author 
 */
public interface UserServiceInt extends BaseServiceInt<UserDTO> {

    /**
     * Finds a user by login ID.
     * 
     * @param name the login ID of the user
     * @param userContext the user context
     * @return UserDTO if found, otherwise null
     */
    public UserDTO findByLoginId(String name, UserContext userContext);

    /**
     * Registers a new user.
     * 
     * @param dto the user data transfer object
     * @param userContext the user context
     * @return the registered UserDTO
     */
    public UserDTO register(UserDTO dto, UserContext userContext);

    /**
     * Authenticates a user using login ID and password.
     * 
     * @param loginId the login ID
     * @param password the password
     * @return authenticated UserDTO if successful, otherwise null
     */
    public UserDTO authenticate(String loginId, String password);

    /**
     * Handles forgot password functionality.
     * 
     * @param loginId the login ID of the user
     * @return true if operation successful, otherwise false
     */
    public boolean forgotPassword(String loginId);

    /**
     * Changes the password of a user.
     * 
     * @param loginId the login ID of the user
     * @param oldPassword the old password
     * @param newPassword the new password
     * @param userContext the user context
     * @return updated UserDTO if successful, otherwise null
     */
    public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext);

}