package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SystemConfigDTO;

public class SystemConfigForm extends BaseForm {

	@NotNull(message = "configId is required")
	private Long configId;
	@NotEmpty(message = "configCode is required")
	private String configCode;
	@NotEmpty(message = "keyName is required")
	private String keyName;
	@NotEmpty(message = "value is required")
	private String value;
	@NotEmpty(message = "status is required")
	private String status;

	public Long getConfigId() {
		return configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	public String getConfigCode() {
		return configCode;
	}

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
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
		SystemConfigDTO dto = initDTO(new SystemConfigDTO());

		dto.setConfigCode(configCode);
		dto.setConfigId(configId);
		dto.setStatus(status);
		dto.setKeyName(keyName);
		dto.setValue(value);

		return dto;
	}

}
