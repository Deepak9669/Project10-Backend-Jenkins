package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PatientDTO;

public class PatientForm extends BaseForm{

	
	@NotEmpty(message = "patientCode is required")
	private String patientCode;
	@NotEmpty(message = "patientName is required")
	private String patientName;
	@NotEmpty(message = "disease is required")
	private String disease;
	@NotEmpty(message = "status is required")
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
	public BaseDTO getDto() {
		
	PatientDTO dto = 	initDTO(new PatientDTO());
	
	dto.setPatientCode(patientCode);
	dto.setStatus(status);
	dto.setDisease(disease);
	dto.setPatientName(patientName);
	
		
		return dto;
	}
	

}
