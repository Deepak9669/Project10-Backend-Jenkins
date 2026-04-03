package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rays.dto.UserDTO;

/**
 * Custom implementation of UserDetailsService for JWT authentication.
 * 
 * This service is responsible for loading user-specific data during
 * authentication. It retrieves user details from the database using
 * UserServiceInt and converts them into Spring Security's UserDetails
 * object.
 * 
 * <p>
 * It also provides a PasswordEncoder bean using BCrypt hashing
 * algorithm for secure password encoding.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Service} to indicate that it is a Spring
 * service component.
 * </p>
 * 
 * @author 
 */
@Service
public class JWTUserDetailsService implements UserDetailsService {

    /**
     * Creates and returns a PasswordEncoder bean.
     * 
     * @return PasswordEncoder instance using BCrypt algorithm
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Service for accessing user-related data.
     */
    @Autowired
    UserServiceInt userService;

    /**
     * Loads user details by username (login ID).
     * 
     * This method is used by Spring Security during authentication
     * to fetch user details from the database.
     * 
     * @param username the username (login ID) of the user
     * @return UserDetails object containing user information
     * @throws UsernameNotFoundException if user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = userService.findByLoginId(username, null);

        if (user == null) {
            System.out.println("user found nuulllll");
            throw new UsernameNotFoundException("User not found with username : " + username);
        }

        return User.builder().username(user.getLoginId()).password(passwordEncoder().encode(user.getPassword()))
                .roles("USER").build();
    }
}