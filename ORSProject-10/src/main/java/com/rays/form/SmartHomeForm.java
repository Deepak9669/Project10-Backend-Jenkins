package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SmartHomeDTO;

public class SmartHomeForm extends BaseForm {

	@NotEmpty(message = "deviceName is required")
	private String deviceName;
	@NotEmpty(message = "roomNo is required")
	private String roomNo;
	@NotEmpty(message = "powerStatus is required")
	private String powerStatus;
	@NotNull(message = "temperature is required")
	private Double temperature;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getPowerStatus() {
		return powerStatus;
	}

	public void setPowerStatus(String powerStatus) {
		this.powerStatus = powerStatus;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public BaseDTO getDto() {

		SmartHomeDTO dto = initDTO(new SmartHomeDTO());

		dto.setDeviceName(deviceName);
		dto.setRoomNo(roomNo);
		dto.setPowerStatus(powerStatus);
		dto.setTemperature(temperature);

		return dto;
	}

}
