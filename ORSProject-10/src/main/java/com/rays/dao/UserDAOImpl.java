package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

/**
 * UserDAOImpl is the DAO implementation class for UserDTO.
 * 
 * It extends BaseDAOImpl which provides generic CRUD operations.
 * 
 * Responsibilities:
 * - Populate role name and user-related fields
 * - Handle deletion of user profile image (attachment)
 * - Build dynamic search conditions using Criteria API
 * 
 * @author Deepak Verma
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

    /**
     * DAO for Role entity
     */
    @Autowired
    RoleDAOInt roleDao;

    /**
     * DAO for Attachment entity
     */
    @Autowired
    AttachmentDAOInt attachmentDao;

    /**
     * Returns the DTO class type
     */
    @Override
    public Class<UserDTO> getDTOClass() {
        return UserDTO.class;
    }

    /**
     * Populates additional fields before save/update
     * 
     * @param dto UserDTO object
     * @param userContext current user context
     */
    @Override
    protected void populate(UserDTO dto, UserContext userContext) {

        // Set role name using roleId
        if (dto.getRoleId() != null && dto.getRoleId() > 0) {
            RoleDTO roleDto = roleDao.findByPK(dto.getRoleId(), userContext);
            dto.setRoleName(roleDto.getName());
        }

        // Preserve last login
        if (dto.getId() != null && dto.getId() > 0) {
            UserDTO userData = findByPK(dto.getId(), userContext);
            dto.setLastLogin(userData.getLastLogin());
        }

        // Preserve imageId
        if (dto.getId() != null && dto.getId() > 0) {
            UserDTO userData = findByPK(dto.getId(), null);
            dto.setImageId(userData.getImageId());
        }
    }

    /**
     * Deletes user along with associated profile image (attachment)
     * 
     * @param dto UserDTO object
     * @param userContext current user context
     */
    @Override
    public void delete(UserDTO dto, UserContext userContext) {

        if (dto.getImageId() != null && dto.getImageId() > 0) {
            attachmentDao.delete(
                attachmentDao.findByPK(dto.getImageId(), null),
                null
            );
        }

        super.delete(dto, userContext);
    }

    /**
     * Builds dynamic WHERE clause based on search criteria
     * 
     * @param dto UserDTO containing search filters
     * @param builder CriteriaBuilder instance
     * @param qRoot Root of query
     * @return list of predicates (conditions)
     */
    @Override
    protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        // Filter by first name
        if (!isEmptyString(dto.getFirstName())) {
            whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
        }

        // Filter by loginId
        if (!isEmptyString(dto.getLoginId())) {
            whereCondition.add(builder.like(qRoot.get("loginId"), dto.getLoginId() + "%"));
        }

        // Filter by roleId
        if (!isZeroNumber(dto.getRoleId())) {
            whereCondition.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));
        }

        // Filter by date of birth
        if (isNotNull(dto.getDob())) {
            whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
        }

        // Filter by status
        if (!isEmptyString(dto.getStatus())) {
            whereCondition.add(builder.equal(qRoot.get("status"), dto.getStatus()));
        }

        return whereCondition;
    }
}