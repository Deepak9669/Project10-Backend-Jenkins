package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ApiDTO;
import com.rays.form.ApiForm;
import com.rays.service.ApiServiceInt;

@RestController
@RequestMapping("Api")
public class ApiCtl extends BaseCtl<ApiForm, ApiDTO, ApiServiceInt> {

}
