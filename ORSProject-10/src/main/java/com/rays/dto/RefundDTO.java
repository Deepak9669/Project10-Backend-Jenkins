package com.rays.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_refund")
public class RefundDTO extends BaseDTO{
	
	@Column(name = "refund_code" , length = 50)
	private String refundCode;
	@Column(name = "amount" , length = 50)
	private Double amount;
	@Column(name = "refund_date" , length = 50)
	private Date refundDate;
	@Column(name = "status" , length = 50)
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
	public String getValue() {
		return refundCode;
	}
	@Override
	public String getUniqueKey() {
		return "refundCode";
	}
	@Override
	public String getUniqueValue() {
		return refundCode;
	}
	@Override
	public String getLabel() {
		return "refundCode";
	}
	@Override
	public String getTableName() {
		return "refund";
	}

}
