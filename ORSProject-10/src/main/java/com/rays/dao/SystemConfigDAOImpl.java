package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SystemConfigDTO;

@Repository
public class SystemConfigDAOImpl extends BaseDAOImpl<SystemConfigDTO> implements SystemConfigDAOInt {

	@Override
	public Class<SystemConfigDTO> getDTOClass() {
		return SystemConfigDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SystemConfigDTO dto, CriteriaBuilder builder,
			Root<SystemConfigDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(isNotNull(dto.getConfigId())) {
			whereCondition.add(builder.equal(qRoot.get("configId"), dto.getConfigId()));
			
		}
		
		if(!isEmptyString(dto.getConfigCode())){
			whereCondition.add(builder.like(qRoot.get("configCode"), dto.getConfigCode() + "%"));
			
		}
		
		if(!isEmptyString(dto.getStatus())){
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
			
		}
		if(!isEmptyString(dto.getValue())){
			whereCondition.add(builder.like(qRoot.get("value"), dto.getValue() + "%"));
			
		}
		
		if(!isEmptyString(dto.getKeyName())){
			whereCondition.add(builder.like(qRoot.get("keyName"), dto.getKeyName() + "%"));
			
		}
		
		return whereCondition;
	}

}
