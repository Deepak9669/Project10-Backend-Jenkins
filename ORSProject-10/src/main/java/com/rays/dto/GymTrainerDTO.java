package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_gym_trainer")
public class GymTrainerDTO extends BaseDTO{

	@Column(name = "trainerId ", length = 50)
	private Long trainerId;
	@Column(name = "trainerName ", length = 50)
	private String trainerName;
	@Column(name = "specialization ", length = 50)
	private String specialization;
	@Column(name = "salary ", length = 50)
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
	public String getValue() {
		return trainerName;
	}

	@Override
	public String getUniqueKey() {
		return "trainerName";
	}

	@Override
	public String getUniqueValue() {
		return trainerName;
	}

	@Override
	public String getLabel() {
		return "trainerName";
	}

	@Override
	public String getTableName() {
		return "GymTrainer";
	}

}
