package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * TimeTableDTO is a Data Transfer Object (DTO) class that represents
 * exam timetable details in the system.
 * 
 * It contains information such as course, subject, exam date,
 * exam time, semester, and description.
 * 
 * This class is mapped to the database table "st_timetable".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

    /** Course ID */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** Course Name */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** Subject ID */
    @Column(name = "subject_id", length = 50)
    private long subjectId;

    /** Subject Name */
    @Column(name = "subject_name", length = 50)
    private String subjectName;

    /** Exam Date */
    @Column(name = "exam_date")
    private Date examDate;

    /** Exam Time */
    @Column(name = "exam_time", length = 50)
    private String examTime;

    /** Semester (e.g., First, Second) */
    @Column(name = "semester", length = 30)
    private String semester;

    /** Description */
    @Column(name = "description", length = 50)
    private String description;

    // Getters and Setters

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns unique key (Course Name)
     */
    @Override
    public String getUniqueKey() {
        return "courseName";
    }

    /**
     * Returns unique value (Course Name)
     */
    @Override
    public String getUniqueValue() {
        return courseName;
    }

    /**
     * Returns label for UI display
     */
    @Override
    public String getLabel() {
        return "TimeTable";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "TimeTable";
    }

    /**
     * Returns display value (Subject + Date + Time)
     */
    @Override
    public String getValue() {
        return subjectName + " - " + examDate + " (" + examTime + ")";
    }
}