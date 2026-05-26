package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SmartHomeDTO;

@Repository
public class SmartHomeDAOImpl extends BaseDAOImpl<SmartHomeDTO> implements SmartHomeDAOInt{

	@Override
	public Class<SmartHomeDTO> getDTOClass() {
		return SmartHomeDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SmartHomeDTO dto, CriteriaBuilder builder,
			Root<SmartHomeDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		// Filter by deviceName
		if (!isEmptyString(dto.getDeviceName())) {
			whereCondition.add(
					builder.like(qRoot.get("deviceName"), dto.getDeviceName() + "%"));
		}

		// Filter by roomNo
		if (!isEmptyString(dto.getRoomNo())) {
			whereCondition.add(
					builder.like(qRoot.get("roomNo"), dto.getRoomNo() + "%"));
		}

		// Filter by powerStatus
		if (!isEmptyString(dto.getPowerStatus())) {
			whereCondition.add(
					builder.like(qRoot.get("powerStatus"), dto.getPowerStatus() + "%"));
		}

		// Filter by temperature
		if (isNotNull(dto.getTemperature())) {
			whereCondition.add(
					builder.equal(qRoot.get("temperature"), dto.getTemperature()));
		}

		return whereCondition;
	}
}
