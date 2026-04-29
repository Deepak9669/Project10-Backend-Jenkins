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

@Repository
public class JobDAOImpl extends BaseDAOImpl<JobDTO> implements JobDAOInt{
	
	@Autowired
	CityDAOInt cityDao;
	
	@Override
	protected void populate(JobDTO dto, UserContext userContext) {
		
		 if (dto.getCityId() != null && dto.getCityId() > 0) {
	            CityDTO cityDto = cityDao.findByPK(dto.getCityId(), userContext);
	            dto.setCityName(cityDto.getCity());
	        }
		
	}
	


	@Override
	public Class<JobDTO> getDTOClass() {
		return JobDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(JobDTO dto, CriteriaBuilder builder, Root<JobDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getJobCode())) {
			whereCondition.add(builder.like(qRoot.get("jobCode"), dto.getJobCode() + "%"));
			
		}
		
		if(!isEmptyString(dto.getJobName())) {
			whereCondition.add(builder.like(qRoot.get("jobName"), dto.getJobName() + "%"));
			
		}
		
		if(isNotNull(dto.getCityId())) {
			whereCondition.add(builder.equal(qRoot.get("cityId"), dto.getCityId()));
			
		}
		
		
		
		return whereCondition;
	}

}
