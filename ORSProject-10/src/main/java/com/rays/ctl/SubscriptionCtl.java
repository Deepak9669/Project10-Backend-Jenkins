package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.SubscriptionDTO;
import com.rays.form.SubscriptionForm;
import com.rays.service.SubscriptionServiceInt;

@RestController
@RequestMapping("Subscription")
public class SubscriptionCtl extends BaseCtl<SubscriptionForm, SubscriptionDTO, SubscriptionServiceInt> {

}
