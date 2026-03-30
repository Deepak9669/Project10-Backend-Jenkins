package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.SubjectForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * SubjectCtl is a REST Controller for handling
 * Subject related operations.
 * 
 * It extends BaseCtl which provides generic CRUD operations.
 * 
 * This controller also provides a preload API to fetch
 * course list for dropdown usage.
 * 
 * All endpoints are mapped under "/Subject".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "Subject")
public class SubjectCtl extends BaseCtl<SubjectForm, SubjectDTO, SubjectServiceInt> {

    /**
     * Service for Course operations
     */
    @Autowired
    private CourseServiceInt courseService;

    /**
     * Preload API to fetch course list
     * 
     * @return ORSResponse containing course list
     */
    @GetMapping("/preload")
    public ORSResponse preload() {

        ORSResponse res = new ORSResponse(true);

        List<DropdownList> list = courseService.search(new CourseDTO(), userContext);

        res.addResult("courseList", list);

        return res;
    }
}