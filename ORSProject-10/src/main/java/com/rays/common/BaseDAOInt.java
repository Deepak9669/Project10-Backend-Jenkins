package com.rays.common;

import java.util.List;

/**
 * Base DAO Interface that defines common database operations
 * like add, update, delete, and search.
 * 
 * This interface is implemented by DAO classes to provide
 * generic CRUD functionality.
 * 
 * @author Deepak Verma
 *
 * @param <T> DTO type extending BaseDTO
 */
public interface BaseDAOInt<T extends BaseDTO> {

    /**
     * Adds a new record to the database
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
     * Deletes a record from the database
     * 
     * @param dto DTO object to be deleted
     * @param userContext current user context
     */
    public void delete(T dto, UserContext userContext);

    /**
     * Finds a record by primary key
     * 
     * @param pk primary key (ID)
     * @param userContext current user context
     * @return DTO object if found
     */
    public T findByPK(long pk, UserContext userContext);

    /**
     * Finds a record using a unique attribute and its value
     * 
     * @param attribute field name
     * @param val value of the field
     * @param userContext current user context
     * @return DTO object if found
     */
    public T findByUniqueKey(String attribute, Object val, UserContext userContext);

    /**
     * Searches records with pagination
     * 
     * @param dto DTO containing search criteria
     * @param pageNo page number
     * @param pageSize number of records per page
     * @param userContext current user context
     * @return list of DTO objects
     */
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches records without pagination
     * 
     * @param dto DTO containing search criteria
     * @param userContext current user context
     * @return list of DTO objects
     */
    public List<T> search(T dto, UserContext userContext);
}