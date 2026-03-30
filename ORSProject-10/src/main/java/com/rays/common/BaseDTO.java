package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * BaseDTO is an abstract class that provides common fields
 * for all DTO (Data Transfer Object) classes.
 * 
 * It includes audit fields like createdBy, modifiedBy,
 * createdDatetime, and modifiedDatetime.
 * 
 * This class also enforces implementation of unique key
 * and label-related methods for generic operations.
 * 
 * @author Deepak Verma
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

    /**
     * Primary key ID
     */
    @Id
    @GeneratedValue(generator = "ncsPk")
    @GenericGenerator(name = "ncsPk", strategy = "native")
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    /**
     * User who created the record
     */
    @Column(name = "created_by", length = 50)
    protected String createdBy = "root";

    /**
     * User who last modified the record
     */
    @Column(name = "modified_by", length = 50)
    protected String modifiedBy = "root";

    /**
     * Record creation timestamp
     */
    @Column(name = "created_datetime")
    protected Timestamp createdDatetime;

    /**
     * Record last modification timestamp
     */
    @Column(name = "modified_datetime")
    protected Timestamp modifiedDatetime;

    /**
     * Returns the unique key field name (e.g., email, loginId)
     * 
     * @return unique key field name
     */
    public abstract String getUniqueKey();

    /**
     * Returns the value of the unique key
     * 
     * @return unique key value
     */
    public abstract String getUniqueValue();

    /**
     * Returns label for display (e.g., name)
     * 
     * @return label value
     */
    public abstract String getLabel();

    /**
     * Returns database table name
     * 
     * @return table name
     */
    public abstract String getTableName();

    /**
     * Gets ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Gets created datetime
     */
    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    /**
     * Sets created datetime
     */
    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    /**
     * Gets modified datetime
     */
    public Timestamp getModifiedDatetime() {
        return modifiedDatetime;
    }

    /**
     * Sets modified datetime
     */
    public void setModifiedDatetime(Timestamp modifiedDatetime) {
        this.modifiedDatetime = modifiedDatetime;
    }

    /**
     * Returns key for dropdown list (ID as String)
     * 
     * @return key value
     */
    public String getKey() {
        return String.valueOf(id);
    }
}