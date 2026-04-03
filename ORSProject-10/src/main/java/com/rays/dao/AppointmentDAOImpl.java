package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AppointmentDTO;

@Repository
public class AppointmentDAOImpl extends BaseDAOImpl<AppointmentDTO> implements AppointmentDAOInt {

	@Override
	public Class<AppointmentDTO> getDTOClass() {
		return AppointmentDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(AppointmentDTO dto, CriteriaBuilder builder, Root<AppointmentDTO> qRoot) {

		List<Predicate> wherCondition = new ArrayList<Predicate>();

		
		if (isNotNull(dto.getAppointmentDate())) {
			wherCondition.add(builder.equal(qRoot.get("appointmentDate"), dto.getAppointmentDate()));

		}

		if (!isEmptyString(dto.getPatientName())) {
			wherCondition.add(builder.like(qRoot.get("patientName"), dto.getPatientName() + " %"));

		}

		if (!isEmptyString(dto.getStatus())) {
			wherCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));

		}

		return wherCondition;
	}

}
