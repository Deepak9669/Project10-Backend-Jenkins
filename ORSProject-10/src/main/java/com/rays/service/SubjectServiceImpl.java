package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SubjectDAOInt;
import com.rays.dto.SubjectDTO;

/**
 * Implementation of SubjectServiceInt interface.
 * 
 * This class provides the business logic for Subject
 * related operations. It extends BaseServiceImpl to
 * inherit common CRUD functionalities and interacts
 * with SubjectDAOInt for data access operations.
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
public class SubjectServiceImpl extends BaseServiceImpl<SubjectDTO, SubjectDAOInt> implements SubjectServiceInt {

}