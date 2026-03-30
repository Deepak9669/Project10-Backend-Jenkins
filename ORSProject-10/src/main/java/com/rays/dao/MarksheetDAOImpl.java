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
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;

/**
 * MarksheetDAOImpl is the DAO implementation class
 * for MarksheetDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * This class is responsible for:
 * - Generating merit list based on marks
 * - Building dynamic search conditions using Criteria API
 * - Populating student name using studentId
 * 
 * @author Deepak Verma
 */
@Repository
public class MarksheetDAOImpl extends BaseDAOImpl<MarksheetDTO> implements MarksheetDAOInt {

    /**
     * DAO for Student entity
     */
    @Autowired
    StudentDAOInt studentDao = null;

    /**
     * Returns top records based on total marks (merit list)
     * 
     * @return list of MarksheetDTO
     */
    @Override
    public List<MarksheetDTO> getMeritList() {

        System.out.println("marksheetDao merit marksheett run start");

        List list = super.marksheetMeritList(
                "from MarksheetDTO order by (physics+chemistry+maths) desc",
                null
        );

        return list;
    }

    /**
     * Builds dynamic WHERE clause based on search criteria
     * 
     * @param dto MarksheetDTO containing search filters
     * @param builder CriteriaBuilder instance
     * @param qRoot Root of query
     * @return list of predicates (conditions)
     */
    @Override
    protected List<Predicate> getWhereClause(MarksheetDTO dto, CriteriaBuilder builder, Root<MarksheetDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        // Filter by name
        if (!isEmptyString(dto.getName())) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        // Filter by roll number
        if (!isEmptyString(dto.getRollNo())) {
            whereCondition.add(builder.like(qRoot.get("rollNo"), dto.getRollNo() + "%"));
        }

        // Filter by student ID
        if (!isZeroNumber(dto.getStudentId())) {
            whereCondition.add(builder.equal(qRoot.get("studentId"), dto.getStudentId()));
        }

        // Filter by ID
        if (!isZeroNumber(dto.getId())) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        return whereCondition;
    }

    /**
     * Populates student name using studentId
     * 
     * @param dto MarksheetDTO object
     * @param userContext current user context
     */
    @Override
    protected void populate(MarksheetDTO dto, UserContext userContext) {

        if (dto.getStudentId() != null) {

            System.out.println("MarksheetDao---" + dto.getStudentId());

            StudentDTO studentDTO = studentDao.findByPK(dto.getStudentId(), userContext);

            if (studentDTO != null) {
                dto.setName(studentDTO.getFirstName() + " " + studentDTO.getLastName());
            }
        }
    }

    /**
     * Returns DTO class type
     */
    @Override
    public Class<MarksheetDTO> getDTOClass() {
        return MarksheetDTO.class;
    }
}