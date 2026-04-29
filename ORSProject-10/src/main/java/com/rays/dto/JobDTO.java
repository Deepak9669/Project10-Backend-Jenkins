package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_job")
public class JobDTO extends BaseDTO {

	@Column(name = "jobCode", length = 50)
	private String jobCode;
	@Column(name = "jobName", length = 50)
	private String jobName;
	@Column(name = "priority", length = 50)
	private String priority;
	@Column(name = "status", length = 50)
	private String status;

	@Column(name = "cityId", length = 50)
	private Long cityId;
	@Column(name = "cityName", length = 50)
	private String cityName;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return jobCode;
	}

	@Override
	public String getUniqueKey() {
		return "jobCode";
	}

	@Override
	public String getUniqueValue() {
		return jobCode;
	}

	@Override
	public String getLabel() {
		return "jobCode";
	}

	@Override
	public String getTableName() {
		return "Job";
	}

}
