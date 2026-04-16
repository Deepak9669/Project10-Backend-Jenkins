package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SubscriptionDTO;

@Repository
public class SubscriptionDAOImpl extends BaseDAOImpl<SubscriptionDTO> implements SubscriptionDAOInt {

	@Override
	public Class<SubscriptionDTO> getDTOClass() {
		return SubscriptionDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SubscriptionDTO dto, CriteriaBuilder builder,
			Root<SubscriptionDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getUserId())) {
			whereCondition.add(builder.equal(qRoot.get("userId"), dto.getUserId()));

		}

		if (isNotNull(dto.getRenewalDate())) {
			whereCondition.add(builder.equal(qRoot.get("renewalDate"), dto.getRenewalDate()));

		}

		if (!isEmptyString(dto.getSubscriptionName())) {
			whereCondition.add(builder.like(qRoot.get("subscriptionName"), dto.getSubscriptionName()));

		}

		if (!isEmptyString(dto.getSubscriptionType())) {
			whereCondition.add(builder.like(qRoot.get("subscriptionType"), dto.getSubscriptionType()));

		}

		return whereCondition;
	}

}
