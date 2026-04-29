package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 * Generic Base DAO Implementation providing common database operations
 * like add, update, delete, search, and criteria-based querying.
 * 
 * This class uses JPA EntityManager and Criteria API.
 * 
 * @author Deepak Verma
 *
 * @param <T> DTO type extending BaseDTO
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

    /**
     * EntityManager for database operations
     */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Returns the DTO class type
     * 
     * @return Class of DTO
     */
    public abstract Class<T> getDTOClass();

    /**
     * Creates WHERE clause dynamically using Criteria API
     * 
     * @param dto DTO containing search criteria
     * @param builder CriteriaBuilder instance
     * @param qRoot Root of query
     * @return List of predicates
     */
    protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

    /**
     * Hook method to populate additional fields before save/update
     * 
     * @param dto DTO object
     * @param userContext current user context
     */
    protected void populate(T dto, UserContext userContext) {
    }

    /**
     * Adds a new record into database
     * 
     * @param dto DTO object
     * @param userContext current user context
     * @return generated ID
     */
    public long add(T dto, UserContext userContext) {

        dto.setCreatedBy(userContext.getLoginId());
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedBy(userContext.getLoginId());
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

        populate(dto, userContext);

        entityManager.persist(dto);
        

        return dto.getId();
    }

    /**
     * Updates an existing record
     * 
     * @param dto DTO object
     * @param userContext current user context
     */
    public void update(T dto, UserContext userContext) {

        dto.setModifiedBy(userContext.getLoginId());
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

        populate(dto, userContext);

        entityManager.merge(dto);
    }

    /**
     * Deletes a record
     * 
     * @param dto DTO object
     * @param userContext current user context
     */
    public void delete(T dto, UserContext userContext) {
        entityManager.remove(dto);
    }

    /**
     * Finds record by primary key
     * 
     * @param pk primary key
     * @param userContext current user context
     * @return DTO object
     */
    public T findByPK(long pk, UserContext userContext) {
        return entityManager.find(getDTOClass(), pk);
    }

    /**
     * Finds record using unique key and value
     * 
     * @param attribute field name
     * @param val value to search
     * @param userContext current user context
     * @return DTO object if found
     */
    public T findByUniqueKey(String attribute, Object val, UserContext userContext) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(getDTOClass());
        Root<T> qRoot = cq.from(getDTOClass());

        Predicate condition = builder.equal(qRoot.get(attribute), val);
        cq.where(condition);

        TypedQuery<T> query = entityManager.createQuery(cq);
        List<T> list = query.getResultList();

        return (list.size() > 0) ? list.get(0) : null;
    }

    /**
     * Creates criteria query based on DTO fields
     * 
     * @param dto DTO object
     * @param userContext current user context
     * @return TypedQuery object
     */
    protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(getDTOClass());
        Root<T> qRoot = cq.from(getDTOClass());

        cq.select(qRoot);

        List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);
        cq.where(whereClause.toArray(new Predicate[0]));

        return entityManager.createQuery(cq);
    }

    /**
     * Searches records with pagination
     * 
     * @param dto DTO containing search criteria
     * @param pageNo page number
     * @param pageSize number of records per page
     * @param userContext current user context
     * @return List of DTOs
     */
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {

        TypedQuery<T> query = createCriteria(dto, userContext);

        if (pageSize > 0) {
            query.setFirstResult(pageNo * pageSize);
            query.setMaxResults(pageSize);
        }

        return query.getResultList();
    }

    /**
     * Searches records without pagination
     * 
     * @param dto DTO containing search criteria
     * @param userContext current user context
     * @return List of DTOs
     */
    public List<T> search(T dto, UserContext userContext) {
        return search(dto, 0, 0, userContext);
    }

    /**
     * Returns top 10 records based on custom HQL query (e.g., merit list)
     * 
     * @param hql HQL query string
     * @param userContext current user context
     * @return List of results
     */
    public List<?> marksheetMeritList(String hql, UserContext userContext) {
        Query q = entityManager.createQuery(hql);
        q.setFirstResult(0);
        q.setMaxResults(10);
        return q.getResultList();
    }

    /**
     * Checks if string is null or empty
     */
    protected boolean isEmptyString(String val) {
        return val == null || val.trim().length() == 0;
    }

    /**
     * Checks if Double value is null or zero
     */
    protected boolean isZeroNumber(Double val) {
        return val == null || val == 0;
    }

    /**
     * Checks if Long value is null or zero
     */
    protected boolean isZeroNumber(Long val) {
        return val == null || val == 0;
    }

    /**
     * Checks if Integer value is null or zero
     */
    protected boolean isZeroNumber(Integer val) {
        return val == null || val == 0;
    }

    /**
     * Checks if object is not null
     */
    protected boolean isNotNull(Object val) {
        return val != null;
    }
}