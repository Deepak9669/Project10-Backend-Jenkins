package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CourseDAOInt;
import com.rays.dto.CourseDTO;

/**
 * Implementation of CourseServiceInt interface.
 * 
 * This class provides the business logic for Course
 * related operations. It extends BaseServiceImpl to
 * inherit common CRUD functionalities and interacts
 * with CourseDAOInt for data access operations.
 * 
 * <p>
 * Annotated with {@code @Service} to indicate it is a
 * Spring service component.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Transactional} to ensure that
 * all operations are executed within a transactional
 * context.
 * </p>
 * 
 * @author 
 */
@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<CourseDTO, CourseDAOInt> implements CourseServiceInt {

}