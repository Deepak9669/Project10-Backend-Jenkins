package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InventoryDTO;

@Repository
public class InventoryDAOImpl extends BaseDAOImpl<InventoryDTO> implements InventoryDAOInt {

	@Override
	public Class<InventoryDTO> getDTOClass() {
		return InventoryDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(InventoryDTO dto, CriteriaBuilder builder, Root<InventoryDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getProductName())) {
			whereCondition.add(builder.equal(qRoot.get("productName"), dto.getProductName() + "%"));

		}

		if (isNotNull(dto.getPrice())) {
			whereCondition.add(builder.equal(qRoot.get("price"), dto.getPrice() + "%"));

		}

		if (isNotNull(dto.getSupplierName())) {
			whereCondition.add(builder.equal(qRoot.get("supplierName"), dto.getSupplierName() + "%"));

		}

		return whereCondition;
	}

}
