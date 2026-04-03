package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * MyProfileForm is a Form Bean class used to capture
 * user profile details from the user interface.
 * 
 * It includes validation to ensure required fields such as
 * name, login ID, gender, phone number, and date of birth
 * are properly filled.
 * 
 * This form is typically used for updating user profile information.
 * 
 * @author Deepak Verma
 */
public class MyProfileForm {

    /** First name of the user */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** Last name of the user */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** Login ID (username/email) */
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    /** Gender */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** Mobile number (10 digits) */
    @NotEmpty(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String phone;

    /** Date of birth */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /**
     * Gets first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    /**
     * Gets gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets date of birth
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets date of birth
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }
}