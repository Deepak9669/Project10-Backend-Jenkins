package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CollegeDTO;
import com.rays.form.CollegeForm;
import com.rays.service.CollegeServiceInt;

/**
 * CollegeCtl is a REST Controller for handling
 * College related operations.
 * 
 * It extends BaseCtl which provides common CRUD APIs
 * like save, delete, get, and search.
 * 
 * All endpoints related to College are mapped under "/College".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "College")
public class CollegeCtl extends BaseCtl<CollegeForm, CollegeDTO, CollegeServiceInt> {

}