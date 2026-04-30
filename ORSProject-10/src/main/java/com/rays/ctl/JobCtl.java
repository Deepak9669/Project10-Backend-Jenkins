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
import com.rays.dto.JobDTO;
import com.rays.form.JobForm;
import com.rays.service.CityServiceInt;
import com.rays.service.JobServiceInt;

/**
 * JobCtl is a REST Controller for handling Job-related requests.
 * It extends BaseCtl to provide common CRUD REST APIs.
 * 
 * This controller also provides a preload API to fetch
 * required data (like city list) for UI dropdowns.
 * 
 * It interacts with JobService and CityService for business logic.
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping("Job")
public class JobCtl extends BaseCtl<JobForm, JobDTO, JobServiceInt> {

    /** Service for City-related operations */
    @Autowired
    CityServiceInt cityService;

    /**
     * Preloads data required for Job form.
     * It fetches city list for dropdown.
     * 
     * @return ORSResponse containing city list
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse();

        CityDTO dto = new CityDTO();

        List<DropdownList> list = cityService.search(dto, userContext);

        res.addResult("cityList", list);
        res.setSuccess(true);

        return res;
    }

}