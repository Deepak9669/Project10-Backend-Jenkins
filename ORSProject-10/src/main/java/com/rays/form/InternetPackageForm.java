package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InternetPackageDTO;

public class InternetPackageForm extends BaseForm {

	
	@NotEmpty(message = "packageName is required")
	private String packageName;
	@NotNull(message = "price is required")
	private Double price;
	@NotNull(message = "dataLimit is required")
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
	public BaseDTO getDto() {

		InternetPackageDTO dto = initDTO(new InternetPackageDTO());

		dto.setPackageName(packageName);
		dto.setPrice(price);
		dto.setDataLimit(dataLimit);

		return dto;
	}

}
