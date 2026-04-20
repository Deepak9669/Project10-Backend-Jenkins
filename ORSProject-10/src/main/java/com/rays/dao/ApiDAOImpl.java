package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ApiDTO;

@Repository
public class ApiDAOImpl extends BaseDAOImpl<ApiDTO> implements ApiDAOInt {

	@Override
	public Class<ApiDTO> getDTOClass() {
		return ApiDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ApiDTO dto, CriteriaBuilder builder, Root<ApiDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getApiKeyCode())) {
			whereCondition.add(builder.like(qRoot.get("apiKeyCode"), dto.getApiKeyCode() + "%"));

		}

		return whereCondition;
	}

}
