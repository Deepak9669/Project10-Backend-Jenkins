package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DecorationDTO;

/**
 * DecorationForm is a Form Bean class used to capture
 * decoration-related input from the user interface.
 * 
 * It includes validation to ensure required fields
 * such as theme, vendor name, and cost are provided.
 * 
 * This form is converted into DecorationDTO using getDto()
 * for persistence operations.
 * 
 * @author Deepak Verma
 */
public class DecorationForm extends BaseForm {

    /** Decoration theme */
    @NotEmpty(message = "theme is required")
    private String theme;

    /** Vendor name */
    @NotEmpty(message = "vendorName is required")
    private String vendorName;

    /** Cost of decoration */
    @NotNull(message = "cost is required")
    private Integer cost;

    /**
     * Gets theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Gets vendor name
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * Sets vendor name
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * Gets cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Sets cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * Converts form data into DTO object
     * 
     * @return populated DecorationDTO
     */
    @Override
    public BaseDTO getDto() {

        DecorationDTO dto = initDTO(new DecorationDTO());

        dto.setTheme(theme);
        dto.setVendorName(vendorName);
        dto.setCost(cost);

        return dto;
    }
}