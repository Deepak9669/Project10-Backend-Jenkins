package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;

/**
 * StudentDAOImpl is the DAO implementation class
 * for StudentDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * This class is responsible for:
 * - Populating college name using collegeId
 * - Building dynamic search conditions using Criteria API
 * 
 * @author Deepak Verma
 */
@Repository
public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

    /**
     * DAO for College entity
     */
    @Autowired
    CollegeDAOInt collegeService = null;

    /**
     * Returns the DTO class type
     */
    @Override
    public Class<StudentDTO> getDTOClass() {
        return StudentDTO.class;
    }

    /**
     * Populates college name using collegeId
     * 
     * @param dto StudentDTO object
     * @param userContext current user context
     */
    @Override
    protected void populate(StudentDTO dto, UserContext userContext) {

        CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId(), userContext);

        if (collegeDTO != null) {
            dto.setCollegeName(collegeDTO.getName());
        }
    }

    /**
     * Builds dynamic WHERE clause based on search criteria
     * 
     * @param dto StudentDTO containing search filters
     * @param builder CriteriaBuilder instance
     * @param qRoot Root of query
     * @return list of predicates (conditions)
     */
    @Override
    protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        // Filter by enrol number
        if (!isEmptyString(dto.getEnrolNo())) {
            whereCondition.add(builder.like(qRoot.get("enrolNo"), dto.getEnrolNo() + "%"));
        }

        // Filter by first name
        if (!isEmptyString(dto.getFirstName())) {
            whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
        }

        // Filter by college name
        if (!isEmptyString(dto.getCollegeName())) {
            whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
        }

        // Filter by email
        if (!isEmptyString(dto.getEmail())) {
            whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
        }

        // Filter by date of birth
        if (isNotNull(dto.getDob())) {
            whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
        }

        // Filter by phone number
        if (!isEmptyString(dto.getPhoneNo())) {
            whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
        }

        return whereCondition;
    }
}