package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.exception.DatabaseException;
import com.rays.exception.DuplicateRecordException;

/**
 * BaseServiceImpl provides generic business logic implementation
 * for CRUD operations using DAO layer.
 * 
 * This class acts as a bridge between Controller and DAO layer.
 * 
 * It handles transactions, validation, and common service logic.
 * 
 * @author Deepak Verma
 *
 * @param <T> DTO type extending BaseDTO
 * @param <D> DAO type extending BaseDAOInt
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

    /**
     * Base DAO object for database operations
     */
    @Autowired
    protected D baseDao;

    /**
     * Adds a new record
     * 
     * @param dto DTO object
     * @param userContext current user context
     * @return generated ID
     * @throws DuplicateRecordException if duplicate record exists
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public long add(T dto, UserContext userContext) throws DuplicateRecordException {
        return baseDao.add(dto, userContext);
    }

    /**
     * Updates an existing record
     * 
     * @param dto DTO object
     * @param userContext current user context
     * @throws DuplicateRecordException if duplicate record exists
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T dto, UserContext userContext) throws DuplicateRecordException {

        T oldDto = baseDao.findByPK(dto.getId(), userContext);

        // Preserve original audit fields
        if (oldDto != null) {
            dto.setCreatedBy(oldDto.getCreatedBy());
            dto.setCreatedDatetime(oldDto.getCreatedDatetime());
        }

        baseDao.update(dto, userContext);
    }

    /**
     * Saves a record (insert or update based on ID)
     * 
     * @param dto DTO object
     * @param userContext current user context
     * @return ID of saved record
     * @throws DuplicateRecordException if duplicate record exists
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public long save(T dto, UserContext userContext) throws DuplicateRecordException {

        Long id = dto.getId();

        if (id != null && id > 0) {
            update(dto, userContext);
        } else {
            id = add(dto, userContext);
        }

        return id;
    }

    /**
     * Finds record by ID
     * 
     * @param id primary key
     * @param userContext current user context
     * @return DTO object
     */
    @Transactional(readOnly = true)
    public T findById(long id, UserContext userContext) {
        return baseDao.findByPK(id, userContext);
    }

    /**
     * Deletes a record by ID
     * 
     * @param id primary key
     * @param userContext current user context
     * @return deleted DTO object
     * @throws DatabaseException if record not found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public T delete(long id, UserContext userContext) {

        T dto = findById(id, userContext);

        if (dto == null) {
            throw new DatabaseException("Record not found");
        }

        baseDao.delete(dto, userContext);
        return dto;
    }

    /**
     * Finds record using unique key
     * 
     * @param attribute field name
     * @param val value of field
     * @param userContext current user context
     * @return DTO object
     */
    @Transactional(readOnly = true)
    public T findByUniqueKey(String attribute, String val, UserContext userContext) {
        return baseDao.findByUniqueKey(attribute, val, userContext);
    }

    /**
     * Searches records with pagination
     * 
     * @param dto DTO containing search criteria
     * @param pageNo page number
     * @param pageSize number of records per page
     * @param userContext current user context
     * @return list of DTOs
     */
    @Transactional(readOnly = true)
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
        return baseDao.search(dto, pageNo, pageSize, userContext);
    }

    /**
     * Searches records without pagination
     * 
     * @param dto DTO containing search criteria
     * @param userContext current user context
     * @return list of DTOs
     */
    @Transactional(readOnly = true)
    public List<T> search(T dto, UserContext userContext) {
        return baseDao.search(dto, userContext);
    }
}