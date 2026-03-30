package com.rays.common;

/**
 * DropdownList interface is used to provide key-value pairs
 * for dropdown components in UI.
 * 
 * Any DTO implementing this interface can be used to populate
 * dropdown lists dynamically.
 * 
 * Typically:
 * - getKey() returns unique identifier (e.g., ID)
 * - getValue() returns display value (e.g., name/label)
 * 
 * @author Deepak Verma
 */
public interface DropdownList {

    /**
     * Returns the key (usually ID)
     * 
     * @return key as String
     */
    public String getKey();

    /**
     * Returns the display value (label)
     * 
     * @return value as String
     */
    public String getValue();

}