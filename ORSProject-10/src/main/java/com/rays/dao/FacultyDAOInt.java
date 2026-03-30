package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.FacultyDTO;

/**
 * FacultyDAOInt is a DAO interface for FacultyDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to Faculty entity.
 * 
 * @author Deepak Verma
 */
public interface FacultyDAOInt extends BaseDAOInt<FacultyDTO> {

}