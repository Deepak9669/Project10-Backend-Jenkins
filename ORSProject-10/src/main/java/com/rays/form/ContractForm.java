package com.rays.form;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ContractDTO;

public class ContractForm extends BaseForm {

	@NotEmpty(message = "contractName is required")
	private String contractName;
	@NotNull(message = "startDate is required")
	private Date startDate;
	@NotNull(message = "endDate is required")
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
	public BaseDTO getDto() {
		ContractDTO dto = initDTO(new ContractDTO());

		dto.setContractName(contractName);
		dto.setEndDate(endDate);
		dto.setStartDate(startDate);

		return dto;
	}

}
