package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CourseDTO;
import com.rays.form.CourseForm;
import com.rays.service.CourseServiceInt;

/**
 * CourseCtl is a REST Controller for handling
 * Course related operations.
 * 
 * It extends BaseCtl which provides common CRUD APIs
 * such as save, delete, get, and search.
 * 
 * All endpoints related to Course are mapped under "/Course".
 * 
 * This controller uses generic architecture to reduce
 * code duplication.
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "Course")
public class CourseCtl extends BaseCtl<CourseForm, CourseDTO, CourseServiceInt> {

}