package com.rays.common;

/**
 * BaseForm is a parent class for all form objects.
 * 
 * It contains common form properties like id, audit fields,
 * pagination details, and utility methods to initialize DTOs.
 * 
 * This class is mainly used in controller layer to transfer
 * request data into DTO objects.
 * 
 * @author Deepak Verma
 */
public class BaseForm {

    /**
     * Primary key ID
     */
    protected Long id;

    /**
     * Created by user
     */
    protected String createdBy;

    /**
     * Modified by user
     */
    protected String modifiedBy;

    /**
     * Created timestamp (in milliseconds)
     */
    protected long createdDatetime;

    /**
     * Modified timestamp (in milliseconds)
     */
    protected long modifiedDatetime;

    /**
     * Array of IDs (used for bulk operations like deleteMany)
     */
    private Long[] ids;

    /**
     * Current page number for pagination
     */
    private int pageNo = 0;

    /**
     * Page size for pagination
     */
    private int pageSize = 5;

    /**
     * Operation type (e.g., save, delete, search)
     */
    private String operation;

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
     * Converts form into DTO object.
     * This method should be overridden in child classes.
     * 
     * @return BaseDTO object
     */
    public BaseDTO getDto() {
        return null;
    }

    /**
     * Initializes DTO with common fields (like ID)
     * 
     * @param dto DTO object
     * @param <T> Generic type extending BaseDTO
     * @return initialized DTO
     */
    public <T extends BaseDTO> T initDTO(T dto) {
        System.out.println("id => base dto => " + id);

        if (id != null && id > 0) {
            dto.setId(id);
        } else {
            dto.setId(null);
        }
        return dto;
    }
}