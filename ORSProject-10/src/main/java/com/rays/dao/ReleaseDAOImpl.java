package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ReleaseDTO;

@Repository
public class ReleaseDAOImpl extends BaseDAOImpl<ReleaseDTO> implements ReleaseDAOInt {

	@Override
	public Class<ReleaseDTO> getDTOClass() {
		return ReleaseDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ReleaseDTO dto, CriteriaBuilder builder, Root<ReleaseDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getReleaseId())) {
			whereCondition.add(builder.equal(qRoot.get("releaseId"), dto.getReleaseId()));

		}

		if (isNotNull(dto.getReleaseDate())) {
			whereCondition.add(builder.equal(qRoot.get("releaseDate"), dto.getReleaseDate()));

		}

		if (!isEmptyString(dto.getVersion())) {
			whereCondition.add(builder.like(qRoot.get("version"), dto.getVersion() + "%"));

		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));

		}

		if (!isEmptyString(dto.getReleaseCode())) {
			whereCondition.add(builder.like(qRoot.get("releaseCode"), dto.getReleaseCode() + "%"));

		}

		return whereCondition;
	}

}
