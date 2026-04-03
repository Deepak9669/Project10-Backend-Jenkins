package com.rays.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * AppointmentDTO is a Data Transfer Object (DTO) class that represents
 * an appointment entity in the system.
 * 
 * It contains details such as patient name, appointment date, and status.
 * This class is mapped to the database table "st_appointment".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_appointment")
public class AppointmentDTO extends BaseDTO {

    /**
     * Name of the patient
     */
    @Column(name = "patientName", length = 50)
    private String patientName;

    /**
     * Date of the appointment
     */
    @Column(name = "appointmentDate", length = 50)
    private Date appointmentDate;

    /**
     * Status of the appointment
     */
    @Column(name = "status", length = 50)
    private String status;

    /**
     * Gets patient name
     * 
     * @return patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Sets patient name
     * 
     * @param patientName
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * Gets appointment date
     * 
     * @return appointmentDate
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Sets appointment date
     * 
     * @param appointmentDate
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Gets appointment status
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets appointment status
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns display value
     */
    @Override
    public String getValue() {
        return patientName;
    }

    /**
     * Returns unique key
     */
    @Override
    public String getUniqueKey() {
        return "patientName";
    }

    /**
     * Returns unique value
     */
    @Override
    public String getUniqueValue() {
        return patientName;
    }

    /**
     * Returns label
     */
    @Override
    public String getLabel() {
        return "patientName";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "appointment";
    }
}