package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InvestorDTO;

@Repository
public class InvestorDAOImpl extends BaseDAOImpl<InvestorDTO> implements InvestorDAOInt {

	@Override
	public Class<InvestorDTO> getDTOClass() {
		return InvestorDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(InvestorDTO dto, CriteriaBuilder builder, Root<InvestorDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getInvestmentAmount())) {
			whereCondition.add(builder.equal(qRoot.get("investmentAmount"), dto.getInvestmentAmount()));

		}

		if (isNotNull(dto.getInvestorId())) {
			whereCondition.add(builder.equal(qRoot.get("investorId"), dto.getInvestorId()));

		}

		if (!isEmptyString(dto.getInvestorName())) {
			whereCondition.add(builder.like(qRoot.get("investorName"), dto.getInvestorName()));

		}

		if (!isEmptyString(dto.getInvestmentType())) {
			whereCondition.add(builder.like(qRoot.get("investmentType"), dto.getInvestmentType()));

		}

		return whereCondition;
	}

}
