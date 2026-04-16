package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_secret")
public class SecretDTO extends BaseDTO {

	@Column(name = "secretId", length = 50)
	private Long secretId;
	@Column(name = "secretCode", length = 50)
	private String secretCode;
	@Column(name = "keyName", length = 50)
	private String keyName;
	@Column(name = "value", length = 50)
	private String value;
	@Column(name = "status", length = 50)
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
	public String getUniqueKey() {
		return "secretCode";
	}

	@Override
	public String getUniqueValue() {
		return secretCode;
	}

	@Override
	public String getLabel() {
		return "secretCode";
	}

	@Override
	public String getTableName() {
		return "Secret";
	}

}
