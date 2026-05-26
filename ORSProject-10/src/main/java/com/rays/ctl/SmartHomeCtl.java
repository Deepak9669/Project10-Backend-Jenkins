package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.SmartHomeDTO;
import com.rays.form.SmartHomeForm;
import com.rays.service.SmartHomeServiceInt;

@RestController
@RequestMapping("SmartHome")
public class SmartHomeCtl extends BaseCtl<SmartHomeForm, SmartHomeDTO, SmartHomeServiceInt> {

}
