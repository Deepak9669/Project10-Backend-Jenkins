package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * CourseDTO is a Data Transfer Object (DTO) class that represents
 * course information in the system.
 * 
 * It contains details such as course name, duration, and description.
 * 
 * This class is mapped to the database table "st_course".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_course")
public class CourseDTO extends BaseDTO {

    /**
     * Name of the course
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Duration of the course (e.g., 6 months, 1 year)
     */
    @Column(name = "duration", length = 50)
    private String duration;

    /**
     * Description of the course
     */
    @Column(name = "description", length = 50)
    private String description;

    /**
     * Gets course name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets course name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets course duration
     * 
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets course duration
     * 
     * @param duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets course description
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets course description
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns unique key for the entity
     */
    @Override
    public String getUniqueKey() {
        return "name";
    }

    /**
     * Returns unique value for the entity
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Returns label for UI display
     */
    @Override
    public String getLabel() {
        return "Course Name";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "Course";
    }

    /**
     * Returns display value
     */
    @Override
    public String getValue() {
        return name;
    }
}