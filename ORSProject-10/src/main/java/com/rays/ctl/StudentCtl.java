package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * StudentCtl is a REST Controller for handling
 * Student related operations.
 * 
 * It extends BaseCtl which provides generic CRUD operations.
 * 
 * This controller also provides a preload API to fetch
 * college list for dropdown usage.
 * 
 * All endpoints are mapped under "/Student".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "Student")
public class StudentCtl extends BaseCtl<StudentForm, StudentDTO, StudentServiceInt> {

    /**
     * Service for College operations
     */
    @Autowired
    private CollegeServiceInt collegeService;

    /**
     * Preload API to fetch college list
     * 
     * @return ORSResponse containing college list
     */
    @GetMapping("preload")
    public ORSResponse preload() {

        ORSResponse res = new ORSResponse(true);

        List<CollegeDTO> list = collegeService.search(new CollegeDTO(), userContext);

        res.addResult("collegeList", list);

        return res;
    }
}