package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RefundDTO;

@Repository
public class RefundDAOImpl extends BaseDAOImpl<RefundDTO> implements RefundDAOInt {

	@Override
	public Class<RefundDTO> getDTOClass() {
		return RefundDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(RefundDTO dto, CriteriaBuilder builder, Root<RefundDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getRefundDate())) {
			whereCondition.add(builder.equal(qRoot.get("refundDate"), dto.getRefundDate()));

		}

		if (isNotNull(dto.getAmount())) {
			whereCondition.add(builder.equal(qRoot.get("amount"), dto.getAmount()));

		}

		if (!isEmptyString(dto.getRefundCode())) {
			whereCondition.add(builder.like(qRoot.get("refundCode"), dto.getRefundCode() + "%"));

		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));

		}

		return whereCondition;
	}

}
