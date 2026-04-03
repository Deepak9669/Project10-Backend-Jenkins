package com.rays.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetForm is a Form Bean class used to capture
 * student marksheet data from the user interface.
 * 
 * It includes validation for roll number, student selection,
 * and marks in Physics, Chemistry, and Mathematics.
 * 
 * This form is converted into MarksheetDTO using getDto()
 * method for persistence operations.
 * 
 * @author Deepak Verma
 */
public class MarksheetForm extends BaseForm {

    /** Roll number of student */
    @NotEmpty(message = "Roll No is required")
    protected String rollNo = null;

    /** Student ID (must be selected) */
    @NotNull(message = "Student Name is required")
    @Min(value = 1, message = "Please select a valid student")
    protected Long studentId;

    /** Student name (optional/display purpose) */
    protected String name = null;

    /** Physics marks (0–99) */
    @NotNull(message = "Physics is required")
    @Min(value = 0, message = "Marks cannot be negative")
    @Max(value = 99, message = "Marks cannot exceed 99")
    protected Integer physics;

    /** Chemistry marks (0–99) */
    @NotNull(message = "Chemistry is required")
    @Min(value = 0, message = "Marks cannot be negative")
    @Max(value = 99, message = "Marks cannot exceed 99")
    protected Integer chemistry;

    /** Maths marks (0–99) */
    @NotNull(message = "Maths is required")
    @Min(value = 0, message = "Marks cannot be negative")
    @Max(value = 99, message = "Marks cannot exceed 99")
    protected Integer maths;

    // Getters and Setters

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    public Integer getChemistry() {
        return chemistry;
    }

    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    /**
     * Converts form data into DTO object
     * 
     * @return populated MarksheetDTO
     */
    @Override
    public BaseDTO getDto() {

        MarksheetDTO dto = initDTO(new MarksheetDTO());

        dto.setRollNo(rollNo);
        dto.setName(name);
        dto.setStudentId(studentId);
        dto.setPhysics(physics);
        dto.setChemistry(chemistry);
        dto.setMaths(maths);

        return dto;
    }
}