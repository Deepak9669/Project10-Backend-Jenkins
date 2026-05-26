package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_inventory")
public class InventoryDTO extends BaseDTO {

	@Column(name = "productName", length = 50)
	private String productName;
	@Column(name = "quantity", length = 50)
	private String quantity;
	@Column(name = "price", length = 50)
	private String price;
	@Column(name = "supplierName", length = 50)
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
	public String getValue() {
		return productName;
	}

	@Override
	public String getUniqueKey() {
		return "productName";
	}

	@Override
	public String getUniqueValue() {
		return productName;
	}

	@Override
	public String getLabel() {
		return "productName";
	}

	@Override
	public String getTableName() {
		return "Inventory";
	}
}
