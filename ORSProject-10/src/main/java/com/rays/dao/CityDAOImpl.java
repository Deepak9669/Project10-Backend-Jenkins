package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CityDTO;

@Repository
public class CityDAOImpl extends BaseDAOImpl<CityDTO> implements CityDAOInt{

	@Override
	public Class<CityDTO> getDTOClass() {
		return CityDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CityDTO dto, CriteriaBuilder builder, Root<CityDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getState())) {
			whereCondition.add(builder.like(qRoot.get("state"), dto.getState() + "%"));
			
		}
		
		if(!isEmptyString(dto.getCity())) {
			whereCondition.add(builder.like(qRoot.get("city"), dto.getCity() + "%"));
			
		}
		
		return whereCondition;
	}

}
