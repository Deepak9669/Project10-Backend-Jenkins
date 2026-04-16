package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_report")
public class ReportDTO extends BaseDTO {

	@Column(name = "reportId", length = 50)
	private Long reportId;
	@Column(name = "reportType", length = 50)
	private String reportType;
	@Column(name = "generatedDate", length = 50)
	private Date generatedDate;
	@Column(name = "remarks", length = 50)
	private String remarks;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String getValue() {
		return reportType;
	}

	@Override
	public String getUniqueKey() {
		return "reportType";
	}

	@Override
	public String getUniqueValue() {
		return reportType;
	}

	@Override
	public String getLabel() {
		return "reportType";
	}

	@Override
	public String getTableName() {
		return "Report";
	}

}
