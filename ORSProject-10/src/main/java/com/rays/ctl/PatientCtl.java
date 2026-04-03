package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.PatientDTO;
import com.rays.form.PatientForm;
import com.rays.service.PatientServiceInt;

@RestController
@RequestMapping("Patient")
public class PatientCtl extends BaseCtl<PatientForm, PatientDTO, PatientServiceInt> {

}
