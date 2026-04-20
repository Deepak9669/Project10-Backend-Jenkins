package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.UsageDTO;
import com.rays.form.UsageForm;
import com.rays.service.UsageServiceInt;

@RestController
@RequestMapping("Usage")
public class UsageCtl extends BaseCtl<UsageForm, UsageDTO, UsageServiceInt>{

}
