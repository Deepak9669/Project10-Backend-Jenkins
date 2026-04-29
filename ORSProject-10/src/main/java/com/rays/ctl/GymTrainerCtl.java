package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.GymTrainerDTO;
import com.rays.form.GymTrainerForm;
import com.rays.service.GymTrainerServiceInt;

@RestController
@RequestMapping("GymTrainer")
public class GymTrainerCtl extends BaseCtl<GymTrainerForm, GymTrainerDTO, GymTrainerServiceInt>{

}
