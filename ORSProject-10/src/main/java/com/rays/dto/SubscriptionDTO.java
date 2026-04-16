package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_subscription")
public class SubscriptionDTO extends BaseDTO {
	
	@Column(name = "userId")
	private Long userId;
	@Column(name = "subscriptionName")
	private String subscriptionName;
	@Column(name = "subscriptionType")
	private String subscriptionType;
	@Column(name = "renewalDate")
	private Date  renewalDate;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	@Override
	public String getValue() {
		return subscriptionName;
	}
	@Override
	public String getUniqueKey() {
		return "subscriptionName";
	}
	@Override
	public String getUniqueValue() {
		return subscriptionName;
	}
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "subscriptionName";
	}
	@Override
	public String getTableName() {
		return "subscription";
	}

}
