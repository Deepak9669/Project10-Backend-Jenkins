package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * FacultyDTO is a Data Transfer Object (DTO) class that represents
 * faculty details in the system.
 * 
 * It contains personal, contact, and academic details such as
 * name, date of birth, gender, phone number, email, qualification,
 * and associated college, course, and subject information.
 * 
 * This class is mapped to the database table "st_faculty".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_faculty")
public class FacultyDTO extends BaseDTO {

    /**
     * First name of the faculty
     */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /**
     * Last name of the faculty
     */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /**
     * Date of birth of the faculty
     */
    @Column(name = "dob")
    private Date dob;

    /**
     * Gender of the faculty
     */
    @Column(name = "gender", length = 10)
    private String gender;

    /**
     * Contact phone number
     */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /**
     * Email address (unique)
     */
    @Column(name = "email", length = 50)
    private String email;

    /**
     * Qualification of the faculty
     */
    @Column(name = "qualification", length = 15)
    private String qualification;

    /**
     * College ID associated with the faculty
     */
    @Column(name = "college_id", length = 50)
    private long collegeId;

    /**
     * College name associated with the faculty
     */
    @Column(name = "college_name", length = 50)
    private String collegeName;

    /**
     * Course ID associated with the faculty
     */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /**
     * Course name associated with the faculty
     */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /**
     * Subject ID associated with the faculty
     */
    @Column(name = "subject_id", length = 50)
    private long subjectId;

    /**
     * Subject name associated with the faculty
     */
    @Column(name = "subject_name", length = 50)
    private String subjectName;

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
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets phone number
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Sets qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Gets college ID
     */
    public long getCollegeId() {
        return collegeId;
    }

    /**
     * Sets college ID
     */
    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * Gets college name
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets college name
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Gets course ID
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Sets course ID
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets subject ID
     */
    public long getSubjectId() {
        return subjectId;
    }

    /**
     * Sets subject ID
     */
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets subject name
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets subject name
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Returns unique key for the entity
     */
    @Override
    public String getUniqueKey() {
        return "email";
    }

    /**
     * Returns unique value for the entity
     */
    @Override
    public String getUniqueValue() {
        return email;
    }

    /**
     * Returns label for UI display
     */
    @Override
    public String getLabel() {
        return "Email";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "Faculty";
    }

    /**
     * Returns display value
     */
    @Override
    public String getValue() {
        return null;
    }
}