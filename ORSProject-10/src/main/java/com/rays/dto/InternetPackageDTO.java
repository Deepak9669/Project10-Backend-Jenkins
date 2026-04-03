package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_internetPackage")
public class InternetPackageDTO extends BaseDTO {

	@Column(name = "packageName", length = 50)
	private String packageName;
	@Column(name = "price", length = 50)
	private Double price;
	@Column(name = "dataLimit", length = 50)
	private Integer dataLimit;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(Integer dataLimit) {
		this.dataLimit = dataLimit;
	}

	@Override
	public String getValue() {
		return packageName;
	}

	@Override
	public String getUniqueKey() {
		return "packageName";
	}

	@Override
	public String getUniqueValue() {
		return packageName;
	}

	@Override
	public String getLabel() {
		return "packageName";
	}

	@Override
	public String getTableName() {
		return "InternetPackage";
	}

}
