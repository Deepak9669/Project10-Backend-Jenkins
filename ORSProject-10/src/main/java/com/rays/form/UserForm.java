package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

/**
 * UserForm is a Form Bean class used to capture
 * user details for registration and management.
 * 
 * It includes advanced validation rules for name,
 * login ID, password, phone numbers, and role selection.
 * 
 * This form is converted into UserDTO using getDto()
 * method for persistence operations.
 * 
 * @author Deepak Verma
 */
public class UserForm extends BaseForm {

    /** First name (only alphabets allowed) */
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Invalid name format")
    @NotEmpty(message = "firstName is required")
    private String firstName;

    /** Last name (only alphabets allowed) */
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Invalid name format")
    @NotEmpty(message = "lastName is required")
    private String lastName;

    @NotEmpty(message = "loginId is required")
    private String loginId;

    /**
     * Password rules:
     * - Must start with a capital letter
     * - Must contain at least one special character
     * - Length between 8 to 12 characters
     */
    @NotEmpty(message = "Password is required")
    @Pattern(
        regexp = "^[A-Z][a-z0-9]*[@$!%*?&][a-z0-9]*$",
        message = "Password must start with capital letter, include one special character, and be 8-12 characters long"
    )
    @Size(min = 8, max = 12)
    private String password;

    /** Role ID (must be selected) */
    @NotNull(message = "Role is required")
    @Min(value = 1, message = "Please select a valid role")
    private Long roleId;

    /** Role name */
    private String roleName = null;

    /** Date of birth */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** Gender */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** Primary mobile number (10 digits) */
    @NotBlank(message = "Mobile No is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
    private String phone;

    /** Alternate mobile number */
    @NotEmpty(message = "Alternate Mobile No is required")
    private String alternateMobile;

    /** User status (Active/Deactive) */
    @NotEmpty(message = "Status is required")
    private String status;

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Converts form data into DTO object
     * 
     * @return populated UserDTO
     */
    @Override
    public BaseDTO getDto() {

        UserDTO dto = initDTO(new UserDTO());

        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setLoginId(loginId);
        dto.setPassword(password);
        dto.setRoleId(roleId);
        dto.setRoleName(roleName);
        dto.setDob(dob);
        dto.setGender(gender);
        dto.setPhone(phone);
        dto.setAlternateMobile(alternateMobile);
        dto.setStatus(status);

        return dto;
    }
}