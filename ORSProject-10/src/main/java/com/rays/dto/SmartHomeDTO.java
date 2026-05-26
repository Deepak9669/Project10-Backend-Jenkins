package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_smartHome")
public class SmartHomeDTO extends BaseDTO {

	@Column(name = "deviceName", length = 50)
	private String deviceName;
	@Column(name = "roomNo", length = 50)
	private String roomNo;
	@Column(name = "powerStatus", length = 50)
	private String powerStatus;
	@Column(name = "temperature")
	private Double temperature;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
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

	@Override
	public String getValue() {
		return roomNo;
	}

	@Override
	public String getUniqueKey() {
		return "roomNo";
	}

	@Override
	public String getUniqueValue() {
		return roomNo;
	}

	@Override
	public String getLabel() {
		return "roomNo";
	}

	@Override
	public String getTableName() {
		return "SmartHome";
	}

}
