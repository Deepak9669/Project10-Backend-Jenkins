package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.AppointmentDTO;
import com.rays.form.AppointmentForm;
import com.rays.service.AppointmentServiceInt;

@RestController
@RequestMapping("Appointment")
public class AppointmentCtl extends BaseCtl<AppointmentForm, AppointmentDTO, AppointmentServiceInt> {

}
