package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimeTableDTO;
import com.rays.form.TimeTableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimeTableServiceInt;

/**
 * TimeTableCtl is a REST Controller for handling
 * TimeTable related operations.
 * 
 * It extends BaseCtl which provides generic CRUD operations.
 * 
 * This controller also provides a preload API to fetch
 * course and subject lists for dropdown usage.
 * 
 * All endpoints are mapped under "/TimeTable".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "TimeTable")
public class TimeTableCtl extends BaseCtl<TimeTableForm, TimeTableDTO, TimeTableServiceInt> {

    /**
     * Service for Course operations
     */
    @Autowired
    private CourseServiceInt courseService;

    /**
     * Service for Subject operations
     */
    @Autowired
    private SubjectServiceInt subjectService;

    /**
     * Preload API to fetch course and subject list
     * 
     * @return ORSResponse containing course and subject lists
     */
    @GetMapping("preload")
    public ORSResponse preload() {

        ORSResponse res = new ORSResponse(true);

        List<CourseDTO> list = courseService.search(new CourseDTO(), userContext);
        List<SubjectDTO> list1 = subjectService.search(new SubjectDTO(), userContext);

        res.addResult("courseList", list);
        res.addResult("subjectList", list1);

        return res;
    }
}