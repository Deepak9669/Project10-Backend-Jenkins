package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_supplier")
public class SupplierDTO extends BaseDTO {

	@Column(name = "supplier_id", length = 50)
	private Long supplierId;
	@Column(name = "supplier_code", length = 50)
	private String supplierCode;
	@Column(name = "supplier_name", length = 50)
	private String supplierName;
	@Column(name = "contact", length = 50)
	private String contact;
	@Column(name = "status", length = 50)
	private String status;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return supplierCode;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "supplierCode";
	}

	@Override
	public String getUniqueValue() {
		return supplierCode;
	}

	@Override
	public String getLabel() {
		return "supplierCode";
	}

	@Override
	public String getTableName() {
		return "Supplier";
	}

}
