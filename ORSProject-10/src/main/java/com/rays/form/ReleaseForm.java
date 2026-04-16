package com.rays.form;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ReleaseDTO;

public class ReleaseForm extends BaseForm {

	@NotNull(message = "releaseId is required")
	private Long releaseId;
	@NotEmpty(message = "releaseCode is required")
	private String releaseCode;
	@NotEmpty(message = "version is required")
	private String version;
	@NotNull(message = "releaseDate is required")
	private Date releaseDate;
	@NotEmpty(message = "status is required")
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
	public BaseDTO getDto() {

		ReleaseDTO dto = initDTO(new ReleaseDTO());

		dto.setReleaseCode(releaseCode);
		dto.setReleaseDate(releaseDate);
		dto.setReleaseId(releaseId);
		dto.setVersion(version);
		dto.setStatus(status);

		return dto;
	}

}
