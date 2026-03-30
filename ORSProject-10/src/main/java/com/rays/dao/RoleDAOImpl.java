package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RoleDTO;

/**
 * RoleDAOImpl is the DAO implementation class
 * for RoleDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * This class is responsible for performing database operations
 * related to Role entity using JPA Criteria API.
 * 
 * It builds dynamic search conditions based on input fields.
 * 
 * @author Deepak Verma
 */
@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt {

    /**
     * Returns the DTO class type
     */
    @Override
    public Class<RoleDTO> getDTOClass() {
        return RoleDTO.class;
    }

    /**
     * Builds dynamic WHERE clause based on search criteria
     * 
     * @param dto RoleDTO containing search filters
     * @param builder CriteriaBuilder instance
     * @param qRoot Root of query
     * @return list of predicates (conditions)
     */
    @Override
    protected List<Predicate> getWhereClause(RoleDTO dto, CriteriaBuilder builder, Root<RoleDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        // Filter by ID
        if (!isZeroNumber(dto.getId())) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        // Filter by name
        if (!isEmptyString(dto.getName())) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        return whereCondition;
    }
}