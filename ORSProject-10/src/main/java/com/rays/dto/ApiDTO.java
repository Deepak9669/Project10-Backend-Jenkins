package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_api")
public class ApiDTO extends BaseDTO{

	@Column(name = "apiKeyId", length = 50)
	private Long apiKeyId;
	@Column(name = "apiKeyCode", length = 50)
	private String apiKeyCode;
	@Column(name = "keyValue", length = 50)
	private String keyValue;
	@Column(name = "issuedTo", length = 50)
	private String issuedTo;
	@Column(name = "status", length = 50)
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
	public String getValue() {
		return apiKeyCode;
	}

	@Override
	public String getUniqueKey() {
		return "apiKeyCode";
	}

	@Override
	public String getUniqueValue() {
		return apiKeyCode;
	}

	@Override
	public String getLabel() {
		return "apiKeyCode";
	}

	@Override
	public String getTableName() {
		return "Api";
	}

}
