package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * AttachmentDAOInt is a DAO interface for AttachmentDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to attachments.
 * 
 * @author Deepak Verma
 */
public interface AttachmentDAOInt extends BaseDAOInt<AttachmentDTO> {

}