package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TaxDTO;

public class TaxForm extends BaseForm {

	@NotNull(message = "taxId is required")
	private Long taxId;
	@NotEmpty(message = "taxCode is required")
	private String taxCode;
	@NotEmpty(message = "taxType is required")
	private String taxType;
	@NotNull(message = "percentage is required")
	private Integer percentage;
	@NotEmpty(message = "status is required")
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
	public BaseDTO getDto() {
		TaxDTO dto = initDTO(new TaxDTO());

		dto.setTaxCode(taxCode);
		dto.setTaxId(taxId);
		dto.setTaxType(taxType);
		dto.setStatus(status);
		dto.setPercentage(percentage);

		return dto;
	}

}
