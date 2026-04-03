package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubjectDTO;

/**
 * SubjectForm is a Form Bean class used to capture
 * subject-related input data from the user interface.
 * 
 * It includes validation to ensure required fields such as
 * course selection, subject name, and description are provided.
 * 
 * This form is converted into SubjectDTO using getDto()
 * method for persistence operations.
 * 
 * @author Deepak Verma
 */
public class SubjectForm extends BaseForm {

    /** Course ID (must be selected) */
    @NotNull(message = "Course is required")
    @Min(value = 1, message = "Please select a valid course")
    private Long courseId = 0L;

    /** Course name */
    private String courseName;

    /** Subject name */
    @NotEmpty(message = "Name is required")
    private String name;

    /** Subject description */
    @NotEmpty(message = "Description is required")
    private String description;

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
     * Gets subject name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets subject name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Converts form data into DTO object
     * 
     * @return populated SubjectDTO
     */
    @Override
    public BaseDTO getDto() {

        SubjectDTO dto = initDTO(new SubjectDTO());

        dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setName(name);
        dto.setDescription(description);

        return dto;
    }
}