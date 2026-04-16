package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.InvestorDAOInt;
import com.rays.dto.InvestorDTO;

@Service
@Transactional
public class InvestorServiceImpl extends BaseServiceImpl<InvestorDTO, InvestorDAOInt> implements InvestorServiceInt {

}
