package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.InternetPackageDAOInt;
import com.rays.dto.InternetPackageDTO;

@Service
@Transactional
public class InternetPackageServiceImpl extends BaseServiceImpl<InternetPackageDTO, InternetPackageDAOInt>
		implements InternetPackageServiceInt {

}
