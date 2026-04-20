package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.UsageDTO;

@Repository
public class UsageDAOImpl extends BaseDAOImpl<UsageDTO> implements UsageDAOInt {

	@Override
	public Class<UsageDTO> getDTOClass() {
		return UsageDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(UsageDTO dto, CriteriaBuilder builder, Root<UsageDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getUsageId())) {
			whereCondition.add(builder.equal(qRoot.get("usageId"), dto.getUsageId()));

		}

		if (!isEmptyString(dto.getUsageCode())) {
			whereCondition.add(builder.like(qRoot.get("usageCode"), dto.getUsageCode() + "%"));
		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}

		if (!isEmptyString(dto.getUsageType())) {
			whereCondition.add(builder.like(qRoot.get("usageType"), dto.getUsageType() + "%"));
		}

		if (!isEmptyString(dto.getUserName())) {
			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));
		}

		return whereCondition;
	}

}
