package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ContractDTO;
import com.rays.form.ContractForm;
import com.rays.service.ContractServiceInt;

@RestController
@RequestMapping("Contract")
public class ContractCtl extends BaseCtl<ContractForm, ContractDTO, ContractServiceInt> {

}
