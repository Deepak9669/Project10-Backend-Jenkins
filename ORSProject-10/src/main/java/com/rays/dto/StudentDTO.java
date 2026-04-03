package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * StudentDTO is a Data Transfer Object (DTO) class that represents
 * student details in the system.
 * 
 * It contains personal and academic information such as enrollment number,
 * name, date of birth, contact details, and associated college details.
 * 
 * This class is mapped to the database table "st_student".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_student")
public class StudentDTO extends BaseDTO {

    /** Enrollment number of the student */
    @Column(name = "enrol_no", length = 20)
    private String enrolNo;

    /** First name of the student */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** Last name of the student */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** Date of birth */
    @Column(name = "dob")
    private Date dob;

    /** Phone number */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /** Email address */
    @Column(name = "email", length = 50)
    private String email;

    /** College ID (foreign key reference) */
    @Column(name = "college_id")
    private Long collegeId;

    /** College name */
    @Column(name = "college_name", length = 50)
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
     * Returns unique key (Enrollment Number)
     */
    @Override
    public String getUniqueKey() {
        return "enrolNo";
    }

    /**
     * Returns unique value (Enrollment Number)
     */
    @Override
    public String getUniqueValue() {
        return enrolNo;
    }

    /**
     * Returns label for UI display
     */
    @Override
    public String getLabel() {
        return "Enroll No";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "Student";
    }

    /**
     * Returns display value (Full Name)
     */
    @Override
    public String getValue() {
        return firstName + " " + lastName;
    }
}