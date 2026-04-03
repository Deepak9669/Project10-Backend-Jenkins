package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableForm is a Form Bean class used to capture
 * exam timetable-related input data from the user interface.
 * 
 * It includes validation to ensure required fields such as
 * course, subject, exam date, exam time, semester, and description
 * are properly filled.
 * 
 * This form is converted into TimeTableDTO using getDto()
 * method for persistence operations.
 * 
 * @author Deepak Verma
 */
public class TimeTableForm extends BaseForm {

    /** Course ID (must be selected) */
    @NotNull(message = "Course is required")
    @Min(value = 1, message = "Please select a valid course")
    private Long courseId = 0L;

    /** Course name */
    private String courseName;

    /** Subject ID (must be selected) */
    @NotNull(message = "Subject is required")
    @Min(value = 1, message = "Please select a valid subject")
    private Long subjectId = 0L;

    /** Subject name */
    private String subjectName;

    /** Exam date */
    @NotNull(message = "Exam Date is required")
    private Date examDate;

    /** Exam time */
    @NotEmpty(message = "Exam Time is required")
    private String examTime;

    /** Semester */
    @NotEmpty(message = "Semester is required")
    private String semester;

    /** Description */
    @NotEmpty(message = "Description is required")
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
     * Converts form data into DTO object
     * 
     * @return populated TimeTableDTO
     */
    @Override
    public BaseDTO getDto() {

        TimeTableDTO dto = initDTO(new TimeTableDTO());

        dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setSubjectId(subjectId);
        dto.setSubjectName(subjectName);
        dto.setExamDate(examDate);
        dto.setExamTime(examTime);
        dto.setSemester(semester);
        dto.setDescription(description);

        return dto;
    }
}