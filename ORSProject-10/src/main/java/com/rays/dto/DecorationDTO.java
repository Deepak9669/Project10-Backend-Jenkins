package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * DecorationDTO is a Data Transfer Object (DTO) class that represents
 * decoration details in the system.
 * 
 * It contains information such as theme, vendor name, and cost of decoration.
 * 
 * This class is mapped to the database table "st_Decoration".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_Decoration")
public class DecorationDTO extends BaseDTO {

    /**
     * Theme of the decoration (e.g., Wedding, Birthday, Corporate)
     */
    @Column(name = "theme", length = 50)
    private String theme;

    /**
     * Name of the decoration vendor
     */
    @Column(name = "vendorName", length = 50)
    private String vendorName;

    /**
     * Cost of the decoration
     */
    @Column(name = "cost", length = 50)
    private Integer cost;

    /**
     * Gets decoration theme
     * 
     * @return theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets decoration theme
     * 
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Gets vendor name
     * 
     * @return vendorName
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * Sets vendor name
     * 
     * @param vendorName
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * Gets decoration cost
     * 
     * @return cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Sets decoration cost
     * 
     * @param cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * Returns display value
     */
    @Override
    public String getValue() {
        return vendorName;
    }

    /**
     * Returns unique key for the entity
     */
    @Override
    public String getUniqueKey() {
        return "vendorName";
    }

    /**
     * Returns unique value for the entity
     */
    @Override
    public String getUniqueValue() {
        return vendorName;
    }

    /**
     * Returns label for UI display
     */
    @Override
    public String getLabel() {
        return "vendorName";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "Decoration";
    }
}