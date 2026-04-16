package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.TaxDTO;
import com.rays.form.TaxForm;
import com.rays.service.TaxServiceInt;

@RestController
@RequestMapping("Tax")
public class TaxCtl extends BaseCtl<TaxForm, TaxDTO, TaxServiceInt> {

}
