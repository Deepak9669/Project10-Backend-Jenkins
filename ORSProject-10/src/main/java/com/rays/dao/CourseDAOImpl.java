package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CourseDTO;

/**
 * CourseDAOImpl is the DAO implementation class for CourseDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * This class is responsible for performing database operations related to
 * Course entity using JPA Criteria API.
 * 
 * It builds dynamic search conditions based on input fields.
 * 
 * @author Deepak Verma
 */
@Repository
public class CourseDAOImpl extends BaseDAOImpl<CourseDTO> implements CourseDAOInt {

	/**
	 * Returns the DTO class type
	 */
	@Override
	public Class<CourseDTO> getDTOClass() {
		return CourseDTO.class;
	}

	/**
	 * Builds dynamic WHERE clause based on search criteria
	 * 
	 * @param dto     CourseDTO containing search filters
	 * @param builder CriteriaBuilder instance
	 * @param qRoot   Root of query
	 * @return list of predicates (conditions)
	 */
	@Override
	protected List<Predicate> getWhereClause(CourseDTO dto, CriteriaBuilder builder, Root<CourseDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		// Filter by course name
		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		// Filter by description
		if (!isEmptyString(dto.getDescription())) {
			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		// Filter by duration
		if (!isEmptyString(dto.getDuration())) {
			whereCondition.add(builder.like(qRoot.get("duration"), dto.getDuration() + "%"));
		}

		return whereCondition;
	}
}