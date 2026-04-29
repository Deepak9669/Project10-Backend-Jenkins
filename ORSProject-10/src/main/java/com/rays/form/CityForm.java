package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CityDTO;

public class CityForm extends BaseForm {

	@NotEmpty(message = "state name is required")
	private String state;
	@NotEmpty(message = "state name is required")
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
	public BaseDTO getDto() {

		CityDTO dto = initDTO(new CityDTO());

		dto.setState(state);
		dto.setCity(city);

		return dto;
	}

}
