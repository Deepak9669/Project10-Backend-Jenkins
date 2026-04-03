package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.rays.common.BaseForm;

/**
 * ChangePasswordForm is a Form Bean class used to handle
 * password change requests from the user interface.
 * 
 * It captures old password, new password, and login ID.
 * Validation annotations ensure required fields and proper length.
 * 
 * This form is typically used in password update functionality.
 * 
 * @author Deepak Verma
 */
public class ChangePasswordForm extends BaseForm {

    /** Old password entered by the user */
    @NotEmpty(message = "Old Password is required")
    @Size(min = 2, max = 10, message = "Password must be between 2 to 10 characters")
    private String oldPassword;

    /** New password to be set */
    @NotEmpty(message = "New Password is required")
    @Size(min = 2, max = 10, message = "Password must be between 2 to 10 characters")
    private String newPassword;

    /** Login ID of the user */
    private String loginId;

    /**
     * Gets old password
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets old password
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Gets new password
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets new password
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Gets login ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets login ID
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}