package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_usage")
public class UsageDTO extends BaseDTO{

	@Column(name = "usageId", length = 50)
	private Long usageId;
	@Column(name = "usageCode", length = 50)
	private String usageCode;
	@Column(name = "userName", length = 50)
	private String userName;
	@Column(name = "usageType", length = 50)
	private String usageType;
	@Column(name = "status", length = 50)
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
	public String getValue() {
		return usageCode;
	}

	@Override
	public String getUniqueKey() {
		return "usageCode";
	}

	@Override
	public String getUniqueValue() {
		return usageCode;
	}

	@Override
	public String getLabel() {
		return "usageCode";
	}

	@Override
	public String getTableName() {
		return "Usage";
	}

}
