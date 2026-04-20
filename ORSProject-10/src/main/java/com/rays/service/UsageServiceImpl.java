package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.UsageDAOInt;
import com.rays.dto.UsageDTO;

@Service
@Transactional
public class UsageServiceImpl extends BaseServiceImpl<UsageDTO, UsageDAOInt> implements UsageServiceInt {

}
