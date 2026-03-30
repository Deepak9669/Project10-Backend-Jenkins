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
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;

/**
 * SubjectDAOImpl is the DAO implementation class
 * for SubjectDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * This class is responsible for:
 * - Populating course name using courseId
 * - Building dynamic search conditions using Criteria API
 * 
 * @author Deepak Verma
 */
@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

    /**
     * DAO for Course entity
     */
    @Autowired
    CourseDAOInt courseDao;

    /**
     * Returns the DTO class type
     */
    @Override
    public Class<SubjectDTO> getDTOClass() {
        return SubjectDTO.class;
    }

    /**
     * Populates course name using courseId
     * 
     * @param dto SubjectDTO object
     * @param userContext current user context
     */
    @Override
    protected void populate(SubjectDTO dto, UserContext userContext) {

        if (dto.getCourseId() != 0) {

            CourseDTO courseDTO = courseDao.findByPK(dto.getCourseId(), userContext);

            if (courseDTO != null) {
                dto.setCourseName(courseDTO.getName());
            }
        }
    }

    /**
     * Builds dynamic WHERE clause based on search criteria
     * 
     * @param dto SubjectDTO containing search filters
     * @param builder CriteriaBuilder instance
     * @param qRoot Root of query
     * @return list of predicates (conditions)
     */
    @Override
    protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        // Filter by subject name
        if (!isEmptyString(dto.getName())) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        // Filter by course name
        if (!isEmptyString(dto.getCourseName())) {
            whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
        }

        return whereCondition;
    }
}