package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CollegeDTO;

/**
 * CollegeDAOImpl is the DAO implementation class
 * for CollegeDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * This class is responsible for performing database operations
 * related to College entity using JPA Criteria API.
 * 
 * It builds dynamic search conditions based on input fields.
 * 
 * @author Deepak Verma
 */
@Repository
public class CollegeDAOImpl extends BaseDAOImpl<CollegeDTO> implements CollegeDAOInt {

    /**
     * Returns the DTO class type
     */
    @Override
    public Class<CollegeDTO> getDTOClass() {
        return CollegeDTO.class;
    }

    /**
     * Builds dynamic WHERE clause based on search criteria
     * 
     * @param dto CollegeDTO containing search filters
     * @param builder CriteriaBuilder instance
     * @param qRoot Root of query
     * @return list of predicates (conditions)
     */
    @Override
    protected List<Predicate> getWhereClause(CollegeDTO dto, CriteriaBuilder builder, Root<CollegeDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        // Filter by name
        if (!isEmptyString(dto.getName())) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        // Filter by city
        if (!isEmptyString(dto.getCity())) {
            whereCondition.add(builder.like(qRoot.get("city"), dto.getCity() + "%"));
        }

        // Filter by state
        if (!isEmptyString(dto.getState())) {
            whereCondition.add(builder.like(qRoot.get("state"), dto.getState() + "%"));
        }

        // Filter by address
        if (!isEmptyString(dto.getAddress())) {
            whereCondition.add(builder.like(qRoot.get("address"), dto.getAddress() + "%"));
        }

        // Filter by phone number
        if (!isEmptyString(dto.getPhoneNo())) {
            whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
        }

        return whereCondition;
    }
}