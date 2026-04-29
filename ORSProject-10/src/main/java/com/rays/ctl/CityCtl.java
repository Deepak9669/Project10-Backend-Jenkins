package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CityDTO;
import com.rays.form.CityForm;
import com.rays.service.CityServiceInt;

@RestController
@RequestMapping("City")
public class CityCtl extends BaseCtl<CityForm, CityDTO, CityServiceInt> {

	@Autowired
	CityServiceInt cityService;

	@GetMapping("preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse();

		CityDTO dto = new CityDTO();

		List<DropdownList> list = cityService.search(dto, userContext);

		res.addResult("cityList", list);

		return res;

	}

}
