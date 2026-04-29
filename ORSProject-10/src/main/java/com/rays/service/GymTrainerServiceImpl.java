package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.GymTrainerDAOInt;
import com.rays.dto.GymTrainerDTO;

@Service
@Transactional
public class GymTrainerServiceImpl extends BaseServiceImpl<GymTrainerDTO, GymTrainerDAOInt>
		implements GymTrainerServiceInt {

}
