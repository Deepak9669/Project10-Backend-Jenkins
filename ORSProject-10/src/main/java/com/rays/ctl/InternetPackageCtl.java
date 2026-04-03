package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.BaseServiceInt;
import com.rays.dto.InternetPackageDTO;
import com.rays.form.InternetPackageForm;
import com.rays.service.InternetPackageServiceInt;

@RestController
@RequestMapping("InternetPackage")
public class InternetPackageCtl extends BaseCtl<InternetPackageForm, InternetPackageDTO, InternetPackageServiceInt> {

}
