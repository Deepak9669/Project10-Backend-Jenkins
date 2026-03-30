package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.FacultyForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.CourseServiceInt;
import com.rays.service.FacultyServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * FacultyCtl is a REST Controller for handling
 * Faculty related operations.
 * 
 * It extends BaseCtl which provides generic CRUD operations.
 * 
 * This controller also provides a preload API to fetch
 * dropdown data like College, Course, and Subject lists.
 * 
 * All endpoints are mapped under "/Faculty".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "Faculty")
public class FacultyCtl extends BaseCtl<FacultyForm, FacultyDTO, FacultyServiceInt> {

    /**
     * Service for College operations
     */
    @Autowired
    CollegeServiceInt collegeService;

    /**
     * Service for Course operations
     */
    @Autowired
    CourseServiceInt courseService;

    /**
     * Service for Subject operations
     */
    @Autowired
    SubjectServiceInt subjectService;

    /**
     * Preload API to fetch dropdown data
     * 
     * @return ORSResponse containing college, course, and subject lists
     */
    @GetMapping("preload")
    public ORSResponse preload() {

        ORSResponse res = new ORSResponse();

        List<DropdownList> collegeList = collegeService.search(new CollegeDTO(), userContext);
        List<DropdownList> courseList = courseService.search(new CourseDTO(), userContext);
        List<DropdownList> subjectList = subjectService.search(new SubjectDTO(), userContext);

        res.addResult("collegeList", collegeList);
        res.addResult("courseList", courseList);
        res.addResult("subjectList", subjectList);

        return res;
    }
}