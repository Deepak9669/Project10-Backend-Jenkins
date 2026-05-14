package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_account")
public class AccountStatusDTO extends BaseDTO{

	@Column(name = "accountCode", length = 50)
	private String accountCode;
	@Column(name = "userName", length = 50)
	private String userName;
	@Column(name = "accountType", length = 50)
	private String accountType;
	@Column(name = "status", length = 50)
	private String status;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return accountCode;
	}

	@Override
	public String getUniqueKey() {
		return "accountCode";
	}

	@Override
	public String getUniqueValue() {
		return accountCode;
	}

	@Override
	public String getLabel() {
		return "accountCode";
	}

	@Override
	public String getTableName() {
		return "Account";
	}

}
