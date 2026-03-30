package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.SubjectDTO;

/**
 * SubjectDAOInt is a DAO interface for SubjectDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to Subject entity.
 * 
 * @author Deepak Verma
 */
public interface SubjectDAOInt extends BaseDAOInt<SubjectDTO> {

}