package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AccountStatusDTO;
@Repository
public class AccountStatusDAOImpl extends BaseDAOImpl<AccountStatusDTO> implements AccountStatusDAOInt{

	@Override
	public Class<AccountStatusDTO> getDTOClass() {
		return AccountStatusDTO.class;
		
	}

	@Override
	protected List<Predicate> getWhereClause(AccountStatusDTO dto, CriteriaBuilder builder,
			Root<AccountStatusDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(isNotNull(dto.getAccountCode())) {
			whereCondition.add(builder.like(qRoot.get("accountCode"), dto.getAccountCode() + "%"));
			
		}
		
		if(isNotNull(dto.getAccountType())) {
			whereCondition.add(builder.like(qRoot.get("accountType"), dto.getAccountType() + "%"));
			
		}
		
		if(isNotNull(dto.getUserName())) {
			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));
			
		}
		
		if(isNotNull(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
			
		}
		
		return whereCondition;
	}

}
