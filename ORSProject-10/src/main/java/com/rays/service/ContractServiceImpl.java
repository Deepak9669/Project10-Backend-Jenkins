package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ContractDAOInt;
import com.rays.dto.ContractDTO;

@Service
@Transactional
public class ContractServiceImpl extends BaseServiceImpl<ContractDTO, ContractDAOInt> implements ContractServiceInt{

}
