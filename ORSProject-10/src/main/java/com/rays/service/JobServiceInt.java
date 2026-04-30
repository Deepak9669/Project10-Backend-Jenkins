package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.JobDTO;

/**
 * JobServiceInt is a Service interface for JobDTO.
 * It extends BaseServiceInt to provide standard business operations
 * such as create, update, delete, find, and search.
 * 
 * This interface acts as a bridge between Controller and DAO layer
 * for Job-related business logic.
 * 
 * @author Deepak Verma
 */
public interface JobServiceInt extends BaseServiceInt<JobDTO>{

}