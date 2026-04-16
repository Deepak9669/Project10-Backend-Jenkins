package com.rays.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_release")
public class ReleaseDTO extends BaseDTO{

	@Column(name = "releaseId", length = 50)
	private Long releaseId;
	@Column(name = "releaseCode", length = 50)
	private String releaseCode;
	@Column(name = "version", length = 50)
	private String version;
	@Column(name = "releaseDate", length = 50)
	private Date releaseDate;
	@Column(name = "status", length = 50)
	private String status;

	public Long getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}

	public String getReleaseCode() {
		return releaseCode;
	}

	public void setReleaseCode(String releaseCode) {
		this.releaseCode = releaseCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return releaseCode;
	}

	@Override
	public String getUniqueKey() {
		return "releaseCode";
	}

	@Override
	public String getUniqueValue() {
		return releaseCode;
	}

	@Override
	public String getLabel() {
		return "releaseCode";
	}

	@Override
	public String getTableName() {
		return "Release";
	}

}
