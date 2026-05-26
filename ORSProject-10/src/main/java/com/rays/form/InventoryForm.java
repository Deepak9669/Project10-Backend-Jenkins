package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InventoryDTO;

public class InventoryForm extends BaseForm {

	@NotEmpty(message = "productName is required")
	private String productName;
	@NotEmpty(message = "quantity is required")
	private String quantity;
	@NotEmpty(message = "price is required")
	private String price;
	@NotEmpty(message = "supplierName is required")
	private String supplierName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public BaseDTO getDto() {

		InventoryDTO dto = initDTO(new InventoryDTO());

		dto.setProductName(productName);
		dto.setPrice(price);
		dto.setQuantity(quantity);
		dto.setSupplierName(supplierName);

		return dto;
	}
}
