package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_city")
public class CityDTO extends BaseDTO {

	@Column(name = "state", length = 50)
	private String state;
	@Column(name = "city", length = 50)
	private String city;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getValue() {
		return city;
	}

	@Override
	public String getUniqueKey() {
		return "city";
	}

	@Override
	public String getUniqueValue() {
		return city;
	}

	@Override
	public String getLabel() {
		return "city";
	}

	@Override
	public String getTableName() {
		return "ity";
	}

}
