package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DecorationDAOInt;
import com.rays.dto.DecorationDTO;

/**
 * Implementation of DecorationServiceInt interface.
 * 
 * This class provides the business logic for Decoration
 * related operations. It extends BaseServiceImpl to
 * inherit common CRUD functionalities and interacts
 * with DecorationDAOInt for data access operations.
 * 
 * <p>
 * Annotated with {@code @Service} to mark it as a Spring
 * service component.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Transactional} to ensure that
 * all methods execute within a transactional context.
 * </p>
 * 
 * @author 
 */
@Service
@Transactional
public class DecorationServiceImpl extends BaseServiceImpl<DecorationDTO, DecorationDAOInt>
        implements DecorationServiceInt {

}