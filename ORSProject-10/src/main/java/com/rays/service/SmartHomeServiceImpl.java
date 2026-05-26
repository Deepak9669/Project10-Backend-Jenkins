package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SmartHomeDAOInt;
import com.rays.dto.SmartHomeDTO;

@Service
@Transactional
public class SmartHomeServiceImpl extends BaseServiceImpl<SmartHomeDTO, SmartHomeDAOInt>
		implements SmartHomeServiceInt {

}
