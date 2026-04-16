package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TaxDAOInt;
import com.rays.dto.TaxDTO;

@Service
@Transactional
public class TaxServiceImpl extends BaseServiceImpl<TaxDTO, TaxDAOInt> implements TaxServiceInt{

}
