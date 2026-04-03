package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * MarksheetDTO is a Data Transfer Object (DTO) class that represents
 * student marksheet details in the system.
 * 
 * It contains information such as roll number, student ID, student name,
 * and marks obtained in Physics, Chemistry, and Mathematics.
 * 
 * This class is mapped to the database table "st_marksheet".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

    /** Roll number of the student */
    @Column(name = "roll_no", length = 20)
    protected String rollNo = null;

    /** Student ID (foreign key reference) */
    @Column(name = "student_id")
    protected Long studentId;

    /** Name of the student */
    @Column(name = "name", length = 50)
    protected String name = null;

    /** Marks obtained in Physics */
    @Column(name = "physics")
    protected Integer physics;

    /** Marks obtained in Chemistry */
    @Column(name = "chemistry")
    protected Integer chemistry;

    /** Marks obtained in Mathematics */
    @Column(name = "maths")
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
     * Returns unique key (roll number)
     */
    @Override
    public String getUniqueKey() {
        return "rollNo";
    }

    /**
     * Returns unique value (roll number)
     */
    @Override
    public String getUniqueValue() {
        return rollNo;
    }

    /**
     * Returns label for UI display
     */
    @Override
    public String getLabel() {
        return "Roll No";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "Marksheet";
    }

    /**
     * Returns display value (Student Name + Roll No)
     */
    @Override
    public String getValue() {
        return name + " (" + rollNo + ")";
    }
}