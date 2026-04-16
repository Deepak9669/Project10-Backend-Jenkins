package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SupplierDTO;

public class SupplierForm extends BaseForm {

	@NotNull(message = "supplierId is required")
	private Long supplierId;
	@NotEmpty(message = "supplierCode is required")
	private String supplierCode;
	@NotEmpty(message = "supplierName is required")
	private String supplierName;
	@NotEmpty(message = "contact is required")
	private String contact;
	@NotEmpty(message = "status is required")
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
	public BaseDTO getDto() {
		SupplierDTO dto = initDTO(new SupplierDTO());

		dto.setStatus(status);
		dto.setSupplierCode(supplierCode);
		dto.setSupplierId(supplierId);
		dto.setSupplierName(supplierName);
		dto.setContact(contact);

		return dto;
	}

}
