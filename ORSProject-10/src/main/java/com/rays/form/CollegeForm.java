package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CollegeDTO;

/**
 * CollegeForm is a Form Bean class used to capture
 * college-related data from the user interface.
 * 
 * It includes validation annotations to ensure all required
 * fields are properly filled before processing.
 * 
 * This form is converted into CollegeDTO using getDto() method
 * for persistence operations.
 * 
 * @author Deepak Verma
 */
public class CollegeForm extends BaseForm {

    /** College name */
    @NotEmpty(message = "Name is required")
    private String name;

    /** College address */
    @NotEmpty(message = "Address is required")
    private String address;

    /** State */
    @NotEmpty(message = "State is required")
    private String state;

    /** City */
    @NotEmpty(message = "City is required")
    private String city;

    /** Phone number (must be 10 digits) */
    @NotNull(message = "Phone No is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
    private String phoneNo;

    /**
     * Gets college name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets college name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets phone number
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets phone number
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Converts form data into DTO object
     * 
     * @return populated CollegeDTO
     */
    @Override
    public BaseDTO getDto() {

        CollegeDTO dto = initDTO(new CollegeDTO());

        dto.setName(name);
        dto.setAddress(address);
        dto.setState(state);
        dto.setCity(city);
        dto.setPhoneNo(phoneNo);

        return dto;
    }
}