package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * UserRegistrationForm is a Form Bean class used to capture
 * user registration data from the user interface.
 * 
 * It includes validation rules for name, login ID, password,
 * date of birth, gender, and phone number to ensure correct
 * and secure user input.
 * 
 * This form is typically used during new user registration.
 * 
 * @author Deepak Verma
 */
public class UserRegistrationForm {

    /** First name (alphabets only) */
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Invalid name format")
    @NotEmpty(message = "firstName is required")
    private String firstName;

    /** Last name (alphabets only) */
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Invalid name format")
    @NotEmpty(message = "lastName is required")
    private String lastName;

    /** Login ID (alphanumeric only) */
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Login ID should contain only letters and numbers")
    @NotEmpty(message = "loginId is required")
    private String loginId;

    /**
     * Password rules:
     * - Must start with capital letter
     * - Must contain at least one special character
     * - Length must be between 8 to 12 characters
     */
    @NotEmpty(message = "Password is required")
    @Pattern(
        regexp = "^[A-Z][a-z0-9]*[@$!%*?&][a-z0-9]*$",
        message = "Password must start with capital letter, include one special character, and be 8-12 characters long"
    )
    @Size(min = 8, max = 12)
    private String password;

    /** Date of birth */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** Gender */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** Mobile number (10 digits) */
    @NotEmpty(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String phone;

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
}