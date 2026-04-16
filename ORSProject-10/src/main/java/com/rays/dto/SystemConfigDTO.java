package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_systemconfig")
public class SystemConfigDTO extends BaseDTO {

	@Column(name = "configId", length = 50)
	private Long configId;
	@Column(name = "configCode", length = 50)
	private String configCode;
	@Column(name = "keyName", length = 50)
	private String keyName;
	@Column(name = "value", length = 50)
	private String value;
	@Column(name = "status", length = 50)
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
	public String getUniqueKey() {
		return "configCode";
	}

	@Override
	public String getUniqueValue() {
		return configCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "configCode";
	}

	@Override
	public String getTableName() {
		return "SystemConfig";
	}

}
