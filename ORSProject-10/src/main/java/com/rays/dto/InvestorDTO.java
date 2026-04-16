package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_investor")
public class InvestorDTO extends BaseDTO {

	@Column(name = "investorId", length = 50)
	private Long investorId;
	@Column(name = "investorName", length = 50)
	private String investorName;
	@Column(name = "investmentAmount", length = 50)
	private Double investmentAmount;
	@Column(name = "investmentType", length = 50)
	private String investmentType;

	public Long getInvestorId() {
		return investorId;
	}

	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public Double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(Double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	@Override
	public String getValue() {
		return investorName;
	}

	@Override
	public String getUniqueKey() {
		return "investorName";
	}

	@Override
	public String getUniqueValue() {
		return investorName;
	}

	@Override
	public String getLabel() {
		return "investorName";
	}

	@Override
	public String getTableName() {
		return "Investor";
	}

}
