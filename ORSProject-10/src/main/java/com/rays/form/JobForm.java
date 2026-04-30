package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.JobDTO;

/**
 * JobForm is used to capture user input for Job entity.
 * It contains validation annotations to ensure correct data input.
 * This form converts data into JobDTO.
 * 
 * @author Deepak Verma
 */
public class JobForm extends BaseForm {

    /** Job code is required */
    @NotEmpty(message = "jobCode is required")
    private String jobCode;

    /** Job name is required and only alphabets are allowed */
    @NotEmpty(message = "jobName is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Only alphabets allowed")
    private String jobName;

    /** Priority is required */
    @NotEmpty(message = "priority is required")
    private String priority;

    /** Status is required */
    @NotEmpty(message = "status is required")
    private String status;

    /** City ID must be greater than 0 */
    @NotNull(message = "cityId is required")
    @Min(1)
    private Long cityId;

    /** City Name */
    private String cityName;

    /**
     * Gets the city ID.
     * 
     * @return cityId
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * Sets the city ID.
     * 
     * @param cityId the city ID to set
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * Gets the city name.
     * 
     * @return cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the city name.
     * 
     * @param cityName the city name to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Gets the job code.
     * 
     * @return jobCode
     */
    public String getJobCode() {
        return jobCode;
    }

    /**
     * Sets the job code.
     * 
     * @param jobCode the job code to set
     */
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    /**
     * Gets the job name.
     * 
     * @return jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets the job name.
     * 
     * @param jobName the job name to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Gets the priority.
     * 
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     * 
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Gets the status.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Converts form data into JobDTO.
     * 
     * @return BaseDTO (JobDTO object)
     */
    @Override
    public BaseDTO getDto() {

        JobDTO dto = initDTO(new JobDTO());

        dto.setJobCode(jobCode);
        dto.setJobName(jobName);
        dto.setStatus(status);
        dto.setPriority(priority);
        dto.setCityId(cityId);
        dto.setCityName(cityName);

        return dto;
    }
}