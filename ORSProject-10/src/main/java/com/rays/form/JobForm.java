package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.JobDTO;

public class JobForm extends BaseForm {

	
	@NotEmpty(message = "jobCode is required")
	private String jobCode;
	@NotEmpty(message = "jobName is required")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Only alphabets allowed")
	private String jobName;
	@NotEmpty(message = "priority is required")
	private String priority;
	@NotEmpty(message = "status is required")
	private String status;

	@NotNull(message = "cityId is required")
	@Min(1)
	private Long cityId;
	
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

	private String cityName;
	
	

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
