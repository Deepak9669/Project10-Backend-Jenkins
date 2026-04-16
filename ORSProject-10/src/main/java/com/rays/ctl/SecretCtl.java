package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.SecretDTO;
import com.rays.form.SecretForm;
import com.rays.service.SecretServiceInt;

@RestController
@RequestMapping("Secret")
public class SecretCtl extends BaseCtl<SecretForm, SecretDTO, SecretServiceInt> {

}
