package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

/**
 * Implementation of RoleServiceInt interface.
 * 
 * This class provides the business logic for Role related
 * operations. It extends BaseServiceImpl to inherit common
 * CRUD functionalities and interacts with RoleDAOInt for
 * data access operations.
 * 
 * <p>
 * Annotated with {@code @Service} to mark it as a Spring
 * service component.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Transactional} to ensure that all
 * methods execute within a transactional context.
 * </p>
 * 
 * @author 
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDAOInt> implements RoleServiceInt {

    /**
     * Finds a Role by its name.
     * 
     * This method retrieves a RoleDTO based on the provided
     * role name using a unique key lookup.
     * 
     * @param name the name of the role
     * @param userContext the user context containing request-related information
     * @return RoleDTO if found, otherwise null
     */
    @Transactional(readOnly = true)
    public RoleDTO findByName(String name, UserContext userContext) {
        return baseDao.findByUniqueKey("name", name, userContext);
    }
}