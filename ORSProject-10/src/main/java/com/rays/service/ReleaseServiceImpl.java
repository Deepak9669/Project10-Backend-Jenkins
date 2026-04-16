package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ReleaseDAOInt;
import com.rays.dto.ReleaseDTO;

@Service
@Transactional
public class ReleaseServiceImpl extends BaseServiceImpl<ReleaseDTO, ReleaseDAOInt> implements ReleaseServiceInt {

}
