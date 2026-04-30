package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.JobDAOInt;
import com.rays.dto.JobDTO;

/**
 * JobServiceImpl is the implementation class of JobServiceInt.
 * It provides business logic for JobDTO and interacts with DAO layer.
 * 
 * This class extends BaseServiceImpl to inherit standard service
 * operations like add, update, delete, findByPK, and search.
 * 
 * It is marked as a Spring Service component and supports
 * transaction management using @Transactional annotation.
 * 
 * @author Deepak Verma
 */
@Service
@Transactional
public class JobServiceImpl extends BaseServiceImpl<JobDTO, JobDAOInt> implements JobServiceInt {

}