package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.DecorationDTO;
import com.rays.form.DecorationForm;
import com.rays.service.DecorationServiceInt;

@RestController
@RequestMapping("Decoration")
public class DecorationCtl extends BaseCtl<DecorationForm, DecorationDTO, DecorationServiceInt> {

}
