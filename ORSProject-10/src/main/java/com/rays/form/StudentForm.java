package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StudentDTO;

/**
 * StudentForm is a Form Bean class used to capture
 * student-related input data from the user interface.
 * 
 * It includes validation to ensure required fields such as
 * enrollment number, personal details, contact information,
 * and college selection are properly filled.
 * 
 * This form is converted into StudentDTO using getDto()
 * method for persistence operations.
 * 
 * @author Deepak Verma
 */
public class StudentForm extends BaseForm {

    /** Enrollment number */
    @NotEmpty(message = "Enroll No is required")
    private String enrolNo;

    /** First name */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** Last name */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** Date of birth */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** Phone number (10 digits) */
    @NotNull(message = "Phone No is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
    private String phoneNo;

    /** Email address */
    @NotEmpty(message = "Email ID is required")
    @Email(message = "Invalid Email format")
    private String email;

    /** College ID (must be selected) */
    @NotNull(message = "College Name is required")
    @Min(value = 1, message = "Please select a valid college")
    private Long collegeId;

    /** College name */
    private String collegeName;

    // Getters and Setters

    public String getEnrolNo() {
        return enrolNo;
    }

    public void setEnrolNo(String enrolNo) {
        this.enrolNo = enrolNo;
    }

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Converts form data into DTO object
     * 
     * @return populated StudentDTO
     */
    @Override
    public BaseDTO getDto() {

        StudentDTO dto = initDTO(new StudentDTO());

        dto.setEnrolNo(enrolNo);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDob(dob);
        dto.setPhoneNo(phoneNo);
        dto.setEmail(email);
        dto.setCollegeId(collegeId);
        dto.setCollegeName(collegeName);

        return dto;
    }
}