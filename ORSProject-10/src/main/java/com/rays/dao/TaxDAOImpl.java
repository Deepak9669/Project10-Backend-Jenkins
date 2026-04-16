package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.TaxDTO;

@Repository
public class TaxDAOImpl extends BaseDAOImpl<TaxDTO> implements TaxDAOInt {

	@Override
	public Class<TaxDTO> getDTOClass() {
		return TaxDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(TaxDTO dto, CriteriaBuilder builder, Root<TaxDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getTaxId())) {
			whereCondition.add(builder.equal(qRoot.get("taxId"), dto.getTaxId()));

		}

		if (isNotNull(dto.getPercentage())) {
			whereCondition.add(builder.equal(qRoot.get("percentage"), dto.getPercentage()));

		}

		if (!isEmptyString(dto.getTaxCode())) {
			whereCondition.add(builder.like(qRoot.get("taxCode"), dto.getTaxCode() + "%"));

		}

		if (!isEmptyString(dto.getTaxType())) {
			whereCondition.add(builder.like(qRoot.get("taxType"), dto.getTaxType() + "%"));

		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));

		}

		return whereCondition;
	}

}
