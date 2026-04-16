package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ReleaseDTO;
import com.rays.form.ReleaseForm;
import com.rays.service.ReleaseServiceInt;

@RestController
@RequestMapping("Release")
public class ReleaseCtl extends BaseCtl<ReleaseForm, ReleaseDTO, ReleaseServiceInt> {

}
