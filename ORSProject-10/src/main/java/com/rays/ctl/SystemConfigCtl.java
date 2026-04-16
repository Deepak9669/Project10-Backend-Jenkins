package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.SystemConfigDTO;
import com.rays.form.SystemConfigForm;
import com.rays.service.SystemConfigServiceInt;

@RestController
@RequestMapping("SystemConfig")
public class SystemConfigCtl extends BaseCtl<SystemConfigForm, SystemConfigDTO, SystemConfigServiceInt> {

}
