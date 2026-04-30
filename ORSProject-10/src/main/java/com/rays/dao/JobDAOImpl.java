package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CityDTO;
import com.rays.dto.JobDTO;
import com.rays.dto.RoleDTO;

/**
 * JobDAOImpl is the implementation class of JobDAOInt.
 * It provides database interaction logic for JobDTO using JPA Criteria API.
 * 
 * This class extends BaseDAOImpl to inherit common CRUD operations
 * and overrides specific methods to customize behavior for Job entity.
 * 
 * It also handles population of additional fields like cityName
 * using related DAO (CityDAO).
 * 
 * @author Deepak Verma
 */
@Repository
public class JobDAOImpl extends BaseDAOImpl<JobDTO> implements JobDAOInt{
	
	/** DAO for City entity */
	@Autowired
	CityDAOInt cityDao;
	
	/**
	 * Populates additional fields in JobDTO before saving/updating.
	 * Fetches city name based on cityId and sets it in DTO.
	 * 
	 * @param dto JobDTO object
	 * @param userContext current user context
	 */
	@Override
	protected void populate(JobDTO dto, UserContext userContext) {
		
		 if (dto.getCityId() != null && dto.getCityId() > 0) {
	            CityDTO cityDto = cityDao.findByPK(dto.getCityId(), userContext);
	            dto.setCityName(cityDto.getCity());
	        }
		
	}
	

	/**
	 * Returns the DTO class type.
	 * 
	 * @return JobDTO class
	 */
	@Override
	public Class<JobDTO> getDTOClass() {
		return JobDTO.class;
	}

	/**
	 * Builds dynamic where clause for search functionality
	 * using JPA Criteria API based on provided DTO values.
	 * 
	 * @param dto JobDTO containing search criteria
	 * @param builder CriteriaBuilder instance
	 * @param qRoot Root of JobDTO
	 * @return list of Predicate conditions
	 */
	@Override
	protected List<Predicate> getWhereClause(JobDTO dto, CriteriaBuilder builder, Root<JobDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		// Filter by jobCode
		if(!isEmptyString(dto.getJobCode())) {
			whereCondition.add(builder.like(qRoot.get("jobCode"), dto.getJobCode() + "%"));
		}
		
		// Filter by jobName
		if(!isEmptyString(dto.getJobName())) {
			whereCondition.add(builder.like(qRoot.get("jobName"), dto.getJobName() + "%"));
		}
		
		if(!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}
		
		// Filter by cityId
		if(isNotNull(dto.getCityId())) {
			whereCondition.add(builder.equal(qRoot.get("cityId"), dto.getCityId()));
		}
		
		return whereCondition;
	}

}