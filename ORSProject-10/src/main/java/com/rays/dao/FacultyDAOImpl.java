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
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

/**
 * FacultyDAOImpl is the DAO implementation class for FacultyDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * This class is responsible for: - Populating related entity names (College,
 * Course, Subject) - Building dynamic search conditions using Criteria API
 * 
 * @author Deepak Verma
 */
@Repository
public class FacultyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt {

	/**
	 * DAO for College entity
	 */
	@Autowired
	CollegeDAOInt collegeDao;

	/**
	 * DAO for Course entity
	 */
	@Autowired
	CourseDAOInt courseDao;

	/**
	 * DAO for Subject entity
	 */
	@Autowired
	SubjectDAOInt subjectDao;

	/**
	 * Returns the DTO class type
	 */
	@Override
	public Class<FacultyDTO> getDTOClass() {
		return FacultyDTO.class;
	}

	/**
	 * Populates related entity names before saving/updating
	 * 
	 * @param dto         FacultyDTO object
	 * @param userContext current user context
	 */
	@Override
	protected void populate(FacultyDTO dto, UserContext userContext) {

		// Set college name from collegeId
		if (dto.getCollegeId() > 0) {
			CollegeDTO collegeDto = collegeDao.findByPK(dto.getCollegeId(), userContext);
			dto.setCollegeName(collegeDto.getName());
		}

		// Set course name from courseId
		if (dto.getCourseId() > 0) {
			CourseDTO courseDto = courseDao.findByPK(dto.getCourseId(), userContext);
			dto.setCourseName(courseDto.getName());
		}

		// Set subject name from subjectId
		if (dto.getSubjectId() > 0) {
			SubjectDTO subjectDto = subjectDao.findByPK(dto.getSubjectId(), userContext);
			dto.setSubjectName(subjectDto.getName());
		}
	}

	/**
	 * Builds dynamic WHERE clause based on search criteria
	 * 
	 * @param dto     FacultyDTO containing search filters
	 * @param builder CriteriaBuilder instance
	 * @param qRoot   Root of query
	 * @return list of predicates (conditions)
	 */
	@Override
	protected List<Predicate> getWhereClause(FacultyDTO dto, CriteriaBuilder builder, Root<FacultyDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		// Filter by first name
		if (!isEmptyString(dto.getFirstName())) {
			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}

		// Filter by email
		if (!isEmptyString(dto.getEmail())) {
			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "&"));
		}

		// Filter by college name
		if (!isEmptyString(dto.getCollegeName())) {
			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}

		// Filter by course name
		if (!isEmptyString(dto.getCourseName())) {
			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		// Filter by subject name
		if (!isEmptyString(dto.getSubjectName())) {
			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName()));
		}

		return whereCondition;
	}
}