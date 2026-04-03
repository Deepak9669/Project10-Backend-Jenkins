package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDTO;

/**
 * RoleForm is a Form Bean class used to capture
 * role-related data from the user interface.
 * 
 * It includes validation to ensure role name and
 * description are provided.
 * 
 * This form is converted into RoleDTO using getDto()
 * method for persistence operations.
 * 
 * It also defines role constants used in the system.
 * 
 * @author Deepak Verma
 */
public class RoleForm extends BaseForm {

    /** Role constants */
    public static final int ADMIN = 1;
    public static final int STUDENT = 2;
    public static final int FACULTY = 3;
    public static final int KIOSK = 4;

    /** Role name */
    @NotEmpty(message = "Name is required")
    private String name;

    /** Role description */
    @NotEmpty(message = "Description is required")
    private String description;

    /**
     * Gets role name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets role name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Converts form data into DTO object
     * 
     * @return populated RoleDTO
     */
    @Override
    public BaseDTO getDto() {

        RoleDTO dto = initDTO(new RoleDTO());

        dto.setName(name);
        dto.setDescription(description);

        return dto;
    }
}