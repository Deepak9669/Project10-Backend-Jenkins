package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SecretDAOInt;
import com.rays.dto.SecretDTO;

@Service
@Transactional
public class SecretServiceImpl extends BaseServiceImpl<SecretDTO, SecretDAOInt> implements SecretServiceInt {

}
