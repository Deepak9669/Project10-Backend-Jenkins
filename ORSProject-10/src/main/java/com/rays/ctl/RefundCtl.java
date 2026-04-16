package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RefundDTO;
import com.rays.form.RefundForm;
import com.rays.service.RefundServiceInt;

@RestController
@RequestMapping("Refund")
public class RefundCtl extends BaseCtl<RefundForm, RefundDTO, RefundServiceInt> {


	@GetMapping("/preload")
	public ORSResponse preload() {

	    ORSResponse res = new ORSResponse(true);

	    return res;
	}

}
