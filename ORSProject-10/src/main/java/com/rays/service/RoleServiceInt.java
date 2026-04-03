package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;

/**
 * Service interface for Role operations.
 * 
 * This interface defines the business methods for handling
 * Role related functionality. It extends BaseServiceInt
 * to inherit standard CRUD operation declarations for
 * RoleDTO.
 * 
 * <p>
 * Classes implementing this interface will provide the
 * concrete business logic for Role related services.
 * </p>
 * 
 * @author 
 */
public interface RoleServiceInt extends BaseServiceInt<RoleDTO> {
    
    /**
     * Finds a Role by its name.
     * 
     * @param name the name of the role
     * @param userContext the user context containing request-related information
     * @return RoleDTO if found, otherwise null
     */
    public RoleDTO findByName(String name, UserContext userContext);

}