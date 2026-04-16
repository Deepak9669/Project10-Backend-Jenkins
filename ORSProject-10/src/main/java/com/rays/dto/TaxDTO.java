package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_tax")
public class TaxDTO extends BaseDTO {

	@Column(name = "taxId", length = 50)
	private Long taxId;
	@Column(name = "taxCode", length = 50)
	private String taxCode;
	@Column(name = "taxType", length = 50)
	private String taxType;
	@Column(name = "percentage", length = 50)
	private Integer percentage;
	@Column(name = "status", length = 50)
	private String status;

	public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return taxCode;
	}

	@Override
	public String getUniqueKey() {
		return "taxCode";
	}

	@Override
	public String getUniqueValue() {
		return taxCode;
	}

	@Override
	public String getLabel() {
		return "taxCode";
	}

	@Override
	public String getTableName() {
		return "tax";
	}
}
