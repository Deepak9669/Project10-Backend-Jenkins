package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ContractDTO;

@Repository

public class ContractDAOImpl extends BaseDAOImpl<ContractDTO> implements ContractDAOInt{

	@Override
	public Class<ContractDTO> getDTOClass() {
		return ContractDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ContractDTO dto, CriteriaBuilder builder, Root<ContractDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getContractName())) {
			whereCondition.add(builder.like(qRoot.get("contractName"), dto.getContractName() + "%"));
			
		}
		
		if(isNotNull(dto.getStartDate())) {
			whereCondition.add(builder.equal(qRoot.get("startDate"), dto.getStartDate()));
			
		}
		
		if(isNotNull(dto.getEndDate())) {
			whereCondition.add(builder.equal(qRoot.get("endDate"), dto.getStartDate()));
			
		}
		
		return whereCondition;
	}

}
