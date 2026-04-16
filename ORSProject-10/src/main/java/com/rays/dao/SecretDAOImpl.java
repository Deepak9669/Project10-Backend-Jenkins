package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SecretDTO;

@Repository
public class SecretDAOImpl extends BaseDAOImpl<SecretDTO> implements SecretDAOInt {

	@Override
	public Class<SecretDTO> getDTOClass() {
		return SecretDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SecretDTO dto, CriteriaBuilder builder, Root<SecretDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getSecretCode())) {
			whereCondition.add(builder.like(qRoot.get("secretCode"), dto.getSecretCode() + "%"));

		}

		if (!isEmptyString(dto.getKeyName())) {
			whereCondition.add(builder.like(qRoot.get("keyName"), dto.getKeyName() + "%"));

		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));

		}

		if (!isEmptyString(dto.getValue())) {
			whereCondition.add(builder.like(qRoot.get("value"), dto.getValue() + "%"));

		}

		if (isNotNull(dto.getSecretId())) {
			whereCondition.add(builder.equal(qRoot.get("secretId"), dto.getSecretId()));

		}

		return whereCondition;
	}

}
