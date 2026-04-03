package com.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * AttachmentDTO is a Data Transfer Object (DTO) class that represents
 * file attachments in the system.
 * 
 * It stores file metadata such as name, type, description, userId,
 * and the actual file content in byte format.
 * 
 * This class is mapped to the database table "ST_ATTACHMENT".
 * 
 * It also supports file upload using MultipartFile.
 * 
 * @author Deepak Verma
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

    /**
     * Name of the file
     */
    @Column(name = "NAME", length = 100)
    protected String name = null;

    /**
     * Type of the file (MIME type)
     */
    @Column(name = "TYPE", length = 100)
    protected String type = null;

    /**
     * Description of the file
     */
    @Column(name = "DESCRIPTION", length = 500)
    protected String description = null;

    /**
     * ID of the user who uploaded the file
     */
    @Column(name = "USER_ID")
    protected Long userId = null;

    /**
     * Actual file content stored as byte array
     */
    @Lob
    @Column(name = "DOC")
    private byte[] doc;

    /**
     * Default constructor
     */
    public AttachmentDTO() {
    }

    /**
     * Constructor to create AttachmentDTO from MultipartFile
     * 
     * @param file uploaded file
     */
    public AttachmentDTO(MultipartFile file) {
        name = file.getOriginalFilename();
        type = file.getContentType();

        try {
            doc = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets file name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets file name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets file type
     * 
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets file type
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
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
     * Gets user ID
     * 
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user ID
     * 
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets file content
     * 
     * @return doc (byte array)
     */
    public byte[] getDoc() {
        return doc;
    }

    /**
     * Sets file content
     * 
     * @param doc
     */
    public void setDoc(byte[] doc) {
        this.doc = doc;
    }

    /**
     * Returns display value (not implemented)
     */
    public String getValue() {
        return null;
    }

    /**
     * Returns unique key (ID as String)
     */
    @Override
    public String getUniqueKey() {
        return id + "";
    }

    /**
     * Returns unique value (not implemented)
     */
    @Override
    public String getUniqueValue() {
        return null;
    }

    /**
     * Returns label for UI
     */
    @Override
    public String getLabel() {
        return "Attachment";
    }

    /**
     * Returns table name
     */
    @Override
    public String getTableName() {
        return "Attachment";
    }
}