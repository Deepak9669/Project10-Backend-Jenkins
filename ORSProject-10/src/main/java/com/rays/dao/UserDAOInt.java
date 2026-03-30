package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.UserDTO;

/**
 * UserDAOInt is a DAO interface for UserDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to User entity.
 * 
 * @author Deepak Verma
 */
public interface UserDAOInt extends BaseDAOInt<UserDTO> {

}