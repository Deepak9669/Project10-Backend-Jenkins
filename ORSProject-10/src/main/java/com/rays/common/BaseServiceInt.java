package com.rays.common;

import java.util.List;

/**
 * BaseServiceInt is a generic service interface that defines
 * common business operations for all DTO classes.
 * 
 * It acts as a contract between Controller and Service layer
 * and provides CRUD and search functionalities.
 * 
 * @author Deepak Verma
 *
 * @param <T> DTO type extending BaseDTO
 */
public interface BaseServiceInt<T extends BaseDTO> {

    /**
     * Adds a new record
     * 
     * @param dto DTO object to be added
     * @param userContext current user context
     * @return generated primary key (ID)
     */
    public long add(T dto, UserContext userContext);

    /**
     * Updates an existing record
     * 
     * @param dto DTO object to be updated
     * @param userContext current user context
     */
    public void update(T dto, UserContext userContext);

    /**
     * Saves a record (insert or update based on ID)
     * 
     * @param dto DTO object
     * @param userContext current user context
     * @return ID of saved record
     */
    public long save(T dto, UserContext userContext);

    /**
     * Deletes a record by ID
     * 
     * @param id primary key
     * @param userContext current user context
     * @return deleted DTO object
     */
    public T delete(long id, UserContext userContext);

    /**
     * Finds a record by ID
     * 
     * @param id primary key
     * @param userContext current user context
     * @return DTO object if found
     */
    public T findById(long id, UserContext userContext);

    /**
     * Finds a record using a unique field
     * 
     * @param attribute field name
     * @param val field value
     * @param userContext current user context
     * @return DTO object if found
     */
    public T findByUniqueKey(String attribute, String val, UserContext userContext);

    /**
     * Searches records with pagination
     * 
     * @param dto DTO containing search criteria
     * @param pageNo page number
     * @param pageSize number of records per page
     * @param userContext current user context
     * @return list of DTO objects
     */
    public List search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches records without pagination
     * 
     * @param dto DTO containing search criteria
     * @param userContext current user context
     * @return list of DTO objects
     */
    public List search(T dto, UserContext userContext);

}