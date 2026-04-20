package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UsageDTO;

public class UsageForm extends BaseForm {

	@NotNull(message = "usageId is required")
	private Long usageId;
	@NotEmpty(message = "usageCode is required")
	private String usageCode;
	@NotEmpty(message = "userName is required")
	private String userName;
	@NotEmpty(message = "usageType is required")
	private String usageType;
	@NotEmpty(message = "status is required")
	private String status;

	public Long getUsageId() {
		return usageId;
	}

	public void setUsageId(Long usageId) {
		this.usageId = usageId;
	}

	public String getUsageCode() {
		return usageCode;
	}

	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsageType() {
		return usageType;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		UsageDTO dto = initDTO(new UsageDTO());

		dto.setUsageCode(usageCode);
		dto.setUsageId(usageId);
		dto.setUsageType(usageType);
		dto.setUserName(userName);
		dto.setStatus(status);

		return dto;
	}

}
