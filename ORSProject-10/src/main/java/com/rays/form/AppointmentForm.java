package com.rays.form;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AppointmentDTO;

/**
 * AppointmentForm is a Form Bean class used to capture
 * appointment-related data from the user interface.
 * 
 * It contains validation annotations to ensure required
 * fields are provided before processing.
 * 
 * This form is converted into AppointmentDTO for persistence.
 * 
 * @author Deepak Verma
 */
public class AppointmentForm extends BaseForm {

    /** Name of the patient */
    @NotEmpty(message = "patientName is required")
    private String patientName;

    /** Appointment date */
    @NotNull(message = "appointmentDate is required")
    private Date appointmentDate;

    /** Status of appointment */
    @NotEmpty(message = "status is required")
    private String status;

    /**
     * Gets patient name
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Sets patient name
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * Gets appointment date
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Sets appointment date
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Gets status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Converts Form object to DTO object
     * 
     * @return populated AppointmentDTO
     */
    @Override
    public BaseDTO getDto() {

        AppointmentDTO dto = initDTO(new AppointmentDTO());

        dto.setAppointmentDate(appointmentDate);
        dto.setPatientName(patientName);
        dto.setStatus(status);

        return dto;
    }
}