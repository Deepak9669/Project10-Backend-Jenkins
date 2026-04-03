package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AttachmentDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * Implementation of AttachmentServiceInt interface.
 * 
 * This class handles the business logic for Attachment
 * related operations. It extends BaseServiceImpl to
 * inherit common CRUD functionalities and interacts
 * with AttachmentDAOInt for database operations.
 * 
 * <p>
 * The {@code @Service} annotation marks this class as a
 * Spring service component.
 * </p>
 * 
 * <p>
 * The {@code @Transactional} annotation ensures that all
 * operations are executed within a transactional context.
 * </p>
 * 
 * @author 
 */
@Service
@Transactional
public class AttachmentServiceImpl extends BaseServiceImpl<AttachmentDTO, AttachmentDAOInt> implements AttachmentServiceInt {

}