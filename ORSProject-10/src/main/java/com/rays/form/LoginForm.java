package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * LoginForm is a Form Bean class used to capture
 * user login credentials from the user interface.
 * 
 * It includes validation to ensure login ID (email)
 * and password are provided correctly.
 * 
 * This form is used during user authentication.
 * 
 * @author Deepak Verma
 */
public class LoginForm {

    /** Login ID (must be a valid email address) */
    @NotEmpty(message = "Login Id is required")
    @Email(message = "Invalid Email format")
    private String loginId;

    /** User password */
    @NotEmpty(message = "Password is required")
    private String password;

    /**
     * Gets login ID
     * 
     * @return loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets login ID
     * 
     * @param loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}