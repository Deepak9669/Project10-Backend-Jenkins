package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.RoleDTO;

/**
 * RoleDAOInt is a DAO interface for RoleDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to Role entity.
 * 
 * @author Deepak Verma
 */
public interface RoleDAOInt extends BaseDAOInt<RoleDTO> {

}