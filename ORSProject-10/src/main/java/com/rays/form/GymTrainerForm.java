package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.GymTrainerDTO;

public class GymTrainerForm extends BaseForm {

	@NotNull(message = "trainerId is required")
	private Long trainerId;
	@NotEmpty(message = "trainerName is required")
	private String trainerName;
	@NotEmpty(message = "specialization is required")
	private String specialization;
	@NotNull(message = "salary is required")
	private Double salary;

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public BaseDTO getDto() {

		GymTrainerDTO dto = initDTO(new GymTrainerDTO());

		dto.setTrainerId(trainerId);
		dto.setTrainerName(trainerName);
		dto.setSpecialization(specialization);
		dto.setSalary(salary);

		return dto;
	}

}
