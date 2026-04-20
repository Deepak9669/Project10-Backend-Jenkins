package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ApiDTO;

public class ApiForm extends BaseForm {

	@NotNull(message = "apiKeyId is required")
	private Long apiKeyId;
	@NotEmpty(message = "apiKeyCode is required")
	private String apiKeyCode;
	@NotEmpty(message = "keyValue is required")
	private String keyValue;
	@NotEmpty(message = "issuedTo is required")
	private String issuedTo;
	@NotEmpty(message = "status is required")
	private String status;

	public Long getApiKeyId() {
		return apiKeyId;
	}

	public void setApiKeyId(Long apiKeyId) {
		this.apiKeyId = apiKeyId;
	}

	public String getApiKeyCode() {
		return apiKeyCode;
	}

	public void setApiKeyCode(String apiKeyCode) {
		this.apiKeyCode = apiKeyCode;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {

		ApiDTO dto = initDTO(new ApiDTO());

		dto.setApiKeyCode(apiKeyCode);
		dto.setApiKeyId(apiKeyId);
		dto.setStatus(status);
		dto.setIssuedTo(issuedTo);
		dto.setKeyValue(keyValue);

		return dto;
	}
}
