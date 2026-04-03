package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * RoleDTO is a Data Transfer Object (DTO) class that represents
 * user roles in the system.
 * 
 * It contains details such as role name and description.
 * Roles are typically used for authorization and access control.
 * 
 * This class is mapped to the database table "st_role".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO {

    /** Name of the role (e.g., Admin, User) */
    @Column(name = "name", length = 50)
    private String name = null;

    /** Description of the role */
    @Column(name = "description", length = 100)
    private String description = null;

    /**
     * Gets role name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets role name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns unique key for the entity
     */
    @Override
    public String getUniqueKey() {
        return "name";
    }

    /**
     * Returns unique value for the entity
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Returns label for UI display
     */
    @Override
    public String getLabel() {
        return "Role Name";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "Role";
    }

    /**
     * Returns display value
     */
    @Override
    public String getValue() {
        return name;
    }
}