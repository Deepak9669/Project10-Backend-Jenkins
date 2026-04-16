package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SystemConfigDAOInt;
import com.rays.dto.SystemConfigDTO;

@Service
@Transactional
public class SystemConfigServiceImpl extends BaseServiceImpl<SystemConfigDTO, SystemConfigDAOInt>
		implements SystemConfigServiceInt {

}
