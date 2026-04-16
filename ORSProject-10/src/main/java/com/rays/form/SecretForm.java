package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SecretDTO;

public class SecretForm extends BaseForm {

	@NotNull(message = "secretId is required")
	private Long secretId;
	@NotEmpty(message = "secretCode is required")
	private String secretCode;
	@NotEmpty(message = "keyName is required")
	private String keyName;
	@NotEmpty(message = "value is required")
	private String value;
	@NotEmpty(message = "status is required")
	private String status;

	public Long getSecretId() {
		return secretId;
	}

	public void setSecretId(Long secretId) {
		this.secretId = secretId;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {

		SecretDTO dto = initDTO(new SecretDTO());

		dto.setSecretCode(secretCode);
		dto.setSecretId(secretId);
		dto.setStatus(status);
		dto.setValue(value);
		dto.setKeyName(keyName);

		return dto;
	}

}
