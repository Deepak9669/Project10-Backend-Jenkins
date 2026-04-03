package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;

/**
 * ForgetPasswordForm is a Form Bean class used to handle
 * forgot password requests from the user interface.
 * 
 * It captures the login ID (usually email/username)
 * required to initiate the password recovery process.
 * 
 * Validation ensures that login ID is not empty.
 * 
 * @author Deepak Verma
 */
public class ForgetPasswordForm extends BaseForm {

    /** Login ID of the user (email/username) */
    @NotEmpty(message = "Login Id is required")
    private String loginId;

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
}