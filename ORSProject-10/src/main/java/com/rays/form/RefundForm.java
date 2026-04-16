package com.rays.form;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RefundDTO;

public class RefundForm extends BaseForm {

	
	@NotEmpty(message = "refundCode is required")
	private String refundCode;
	@NotNull(message = "amount is required")
	private Double amount;
	@NotNull(message = "refundDate is required")
	private Date refundDate;
	@NotEmpty(message = "status is required")
	private String status;

	

	public String getRefundCode() {
		return refundCode;
	}

	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		RefundDTO dto = initDTO(new RefundDTO());

		dto.setRefundCode(refundCode);
		dto.setRefundDate(refundDate);
		dto.setAmount(amount);
		dto.setStatus(status);

		return dto;
	}

}
