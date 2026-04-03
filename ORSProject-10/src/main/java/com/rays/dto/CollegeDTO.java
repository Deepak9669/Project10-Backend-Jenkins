package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * CollegeDTO is a Data Transfer Object (DTO) class that represents
 * college information in the system.
 * 
 * It contains details such as college name, address, state, city,
 * and phone number.
 * 
 * This class is mapped to the database table "st_college".
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "st_college")
public class CollegeDTO extends BaseDTO {

    /**
     * Name of the college
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Address of the college
     */
    @Column(name = "address", length = 50)
    private String address;

    /**
     * State where the college is located
     */
    @Column(name = "state", length = 50)
    private String state;

    /**
     * City where the college is located
     */
    @Column(name = "city", length = 50)
    private String city;

    /**
     * Contact phone number of the college
     */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /**
     * Gets college name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets college name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets state
     * 
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets city
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city
     * 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets phone number
     * 
     * @return phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets phone number
     * 
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
        return "College Name";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "College";
    }

    /**
     * Returns display value
     */
    @Override
    public String getValue() {
        return name;
    }
}