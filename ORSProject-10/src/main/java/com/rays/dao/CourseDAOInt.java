package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.CourseDTO;

/**
 * CourseDAOInt is a DAO interface for CourseDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to Course entity.
 * 
 * @author Deepak Verma
 */
public interface CourseDAOInt extends BaseDAOInt<CourseDTO> {

}