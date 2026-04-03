package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;

/**
 * Implementation of CollegeServiceInt interface.
 * 
 * This class provides the business logic for College
 * related operations. It extends BaseServiceImpl to
 * inherit common CRUD functionalities and interacts
 * with CollegeDAOInt for data access operations.
 * 
 * <p>
 * Annotated with {@code @Service} to define it as a
 * Spring service component.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Transactional} to ensure all
 * methods execute within a transactional context.
 * </p>
 * 
 * @author 
 */
@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDTO, CollegeDAOInt> implements CollegeServiceInt {
    
    

}