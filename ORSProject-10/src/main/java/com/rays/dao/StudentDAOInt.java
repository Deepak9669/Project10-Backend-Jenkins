package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.StudentDTO;

/**
 * StudentDAOInt is a DAO interface for StudentDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to Student entity.
 * 
 * @author Deepak Verma
 */
public interface StudentDAOInt extends BaseDAOInt<StudentDTO> {

}