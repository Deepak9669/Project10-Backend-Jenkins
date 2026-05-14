package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AccountStatusDAOInt;
import com.rays.dto.AccountStatusDTO;

@Service
@Transactional
public class AccountStatusServiceImpl extends BaseServiceImpl<AccountStatusDTO, AccountStatusDAOInt>
		implements AccountStatusServiceInt {
			

}
