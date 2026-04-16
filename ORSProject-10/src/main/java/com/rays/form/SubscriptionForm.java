package com.rays.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubscriptionDTO;


public class SubscriptionForm extends BaseForm {

	@NotNull(message = "userId is required")
	private Long userId;
	@NotEmpty(message = "subscriptionName is required")
	private String subscriptionName;
	@NotEmpty(message = "subscriptionType is required")
	private String subscriptionType;
	@NotNull(message = "renewalDate is required")
	private Date renewalDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	@Override
	public BaseDTO getDto() {

		SubscriptionDTO dto = initDTO(new SubscriptionDTO());

		dto.setSubscriptionName(subscriptionName);
		dto.setSubscriptionType(subscriptionType);
		dto.setRenewalDate(renewalDate);
		dto.setUserId(userId);

		return dto;
	}

}