package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SupplierDTO;

@Repository
public class SupplierDAOImpl extends BaseDAOImpl<SupplierDTO> implements SupplierDAOInt {

	@Override
	public Class<SupplierDTO> getDTOClass() {
		return SupplierDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SupplierDTO dto, CriteriaBuilder builder, Root<SupplierDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));

		}

		if (!isEmptyString(dto.getSupplierCode())) {
			whereCondition.add(builder.like(qRoot.get("supplierCode"), dto.getSupplierCode() + "%"));

		}

		if (!isEmptyString(dto.getSupplierName())) {
			whereCondition.add(builder.like(qRoot.get("supplierName"), dto.getSupplierName() + "%"));

		}

		if (!isEmptyString(dto.getContact())) {
			whereCondition.add(builder.like(qRoot.get("contact"), dto.getContact() + "%"));

		}

		if (isNotNull(dto.getSupplierId())) {
			whereCondition.add(builder.equal(qRoot.get("supplierId"), dto.getSupplierId()));

		}

		return whereCondition;
	}

}
