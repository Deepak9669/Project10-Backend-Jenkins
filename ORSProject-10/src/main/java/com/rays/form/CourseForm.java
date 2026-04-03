package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CourseDTO;

/**
 * CourseForm is a Form Bean class used to capture
 * course-related input data from the user interface.
 * 
 * It includes validation to ensure required fields
 * like name, duration, and description are provided.
 * 
 * This form is converted into CourseDTO using getDto() method
 * for database operations.
 * 
 * @author Deepak Verma
 */
public class CourseForm extends BaseForm {

    /** Course name */
    @NotEmpty(message = "Name is required")
    private String name;

    /** Course duration (e.g., 6 months, 1 year) */
    @NotEmpty(message = "Duration is required")
    private String duration;

    /** Course description */
    @NotEmpty(message = "Description is required")
    private String description;

    /**
     * Gets course name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets course name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
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
     * @return populated CourseDTO
     */
    @Override
    public BaseDTO getDto() {

        CourseDTO dto = initDTO(new CourseDTO());

        dto.setName(name);
        dto.setDuration(duration);
        dto.setDescription(description);

        return dto;
    }
}