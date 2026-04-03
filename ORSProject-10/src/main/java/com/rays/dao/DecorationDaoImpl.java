package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.DecorationDTO;

@Repository
public class DecorationDaoImpl extends BaseDAOImpl<DecorationDTO> implements DecorationDAOInt {

	@Override
	public Class<DecorationDTO> getDTOClass() {
		return DecorationDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(DecorationDTO dto, CriteriaBuilder builder, Root<DecorationDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getCost())) {
			whereCondition.add(builder.equal(qRoot.get("cost"), dto.getCost()));

		}
		
		if(!isEmptyString(dto.getVendorName())) {
			whereCondition.add(builder.like(qRoot.get("vendorName"), dto.getVendorName() + "%"));
			
		}
		
		if(!isEmptyString(dto.getTheme())) {
			whereCondition.add(builder.like(qRoot.get("theme"), dto.getTheme() + "%"));
			
		}


		return whereCondition;
	}

}
