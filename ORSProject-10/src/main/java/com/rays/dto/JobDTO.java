package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * JobDTO represents a Job entity in the system.
 * It contains job-related information such as job code,
 * job name, priority, status, and city details.
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_job")
public class JobDTO extends BaseDTO {

    /** Job Code of the job */
    @Column(name = "jobCode", length = 50)
    private String jobCode;

    /** Name of the job */
    @Column(name = "jobName", length = 50)
    private String jobName;

    /** Priority level of the job */
    @Column(name = "priority", length = 50)
    private String priority;

    /** Status of the job */
    @Column(name = "status", length = 50)
    private String status;

    /** City ID associated with the job */
    @Column(name = "cityId", length = 50)
    private Long cityId;

    /** City Name associated with the job */
    @Column(name = "cityName", length = 50)
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
     * Returns the value used in UI (jobCode).
     */
    @Override
    public String getValue() {
        return jobCode;
    }

    /**
     * Returns the unique key field name.
     */
    @Override
    public String getUniqueKey() {
        return "jobCode";
    }

    /**
     * Returns the unique value of the object.
     */
    @Override
    public String getUniqueValue() {
        return jobCode;
    }

    /**
     * Returns the label used for display.
     */
    @Override
    public String getLabel() {
        return "jobCode";
    }

    /**
     * Returns the table name.
     */
    @Override
    public String getTableName() {
        return "Job";
    }
}