package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_patient")
public class PatientDTO extends BaseDTO {

	
	@Column(name = "patientCode", length = 50)
	private String patientCode;
	@Column(name = "patientName", length = 50)
	private String patientName;
	@Column(name = "disease", length = 50)
	private String disease;
	@Column(name = "status", length = 50)
	private String status;

	

	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return patientCode;
	}

	@Override
	public String getUniqueKey() {
		return "patientCode";
	}

	@Override
	public String getUniqueValue() {
		return patientCode;
	}

	@Override
	public String getLabel() {
		return "patientCode";
	}

	@Override
	public String getTableName() {
		return "patient";
	}

}
