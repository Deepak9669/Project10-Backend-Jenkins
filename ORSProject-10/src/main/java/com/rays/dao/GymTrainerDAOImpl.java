package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.GymTrainerDTO;

@Repository
public class GymTrainerDAOImpl extends BaseDAOImpl<GymTrainerDTO> implements GymTrainerDAOInt{

	@Override
	public Class<GymTrainerDTO> getDTOClass() {
		return GymTrainerDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(GymTrainerDTO dto, CriteriaBuilder builder, Root<GymTrainerDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(isNotNull(dto.getTrainerId())) {
			whereCondition.add(builder.equal(qRoot.get("trainerId"), dto.getTrainerId()));
			
		}
		
		if(!isEmptyString(dto.getTrainerName())) {
			whereCondition.add(builder.like(qRoot.get("trainerName"), dto.getTrainerName() + "%"));
			
		}
		
		if(!isEmptyString(dto.getSpecialization())) {
			whereCondition.add(builder.like(qRoot.get("specialization"), dto.getSpecialization() + "%"));
			
		}
		
		
		return whereCondition;
	}
	
	

}
