package com.rays.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_contract")
public class ContractDTO extends BaseDTO{
	
	@Column(name = "contractName" , length = 50)
	private String contractName;
	@Column(name = "startDate" , length = 50)
	private Date startDate;
	@Column(name = "endDate" , length = 50)
	private Date endDate;

	
	
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String getValue() {
		return contractName;
	}
	@Override
	public String getUniqueKey() {
		return "contractName";
	}
	@Override
	public String getUniqueValue() {
		return contractName;
	}
	@Override
	public String getLabel() {
		return "contractName";
	}
	@Override
	public String getTableName() {
		return "contract";
	}

}
