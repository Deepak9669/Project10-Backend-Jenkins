package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * MarksheetCtl is a REST Controller for handling Marksheet related operations.
 * 
 * It extends BaseCtl which provides generic CRUD operations.
 * 
 * This controller also provides: - Preload data for dropdowns - Fetch marksheet
 * by roll number - Fetch merit list
 * 
 * All endpoints are mapped under "/Marksheet".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "Marksheet")
public class MarksheetCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

	/**
	 * Service for Student operations
	 */
	@Autowired
	private StudentServiceInt studentService;

	/**
	 * Service for Marksheet operations
	 */
	@Autowired
	private MarksheetServiceInt marksheetService;

	/**
	 * Preload API to fetch student and marksheet list
	 * 
	 * @return ORSResponse containing dropdown data
	 */
	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		List<StudentDTO> list = studentService.search(new StudentDTO(), userContext);
		res.addResult("studentList", list);

		List<DropdownList> mlist = marksheetService.search(new MarksheetDTO(), userContext);
		res.addResult("marksheetList", mlist);

		return res;
	}

	/**
	 * Fetch marksheet by roll number
	 * 
	 * @param rollNo roll number of student
	 * @return ORSResponse with marksheet data
	 */
	@GetMapping("rollno/{rollNo}")
	public ORSResponse rollNo(@PathVariable String rollNo) {

		ORSResponse res = new ORSResponse(true);

		MarksheetDTO dto = baseService.findByRollNo(rollNo, userContext);

		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}

		return res;
	}

	/**
	 * Fetch merit list of students
	 * 
	 * @return ORSResponse containing merit list
	 */
	@GetMapping("meritlist")
	public ORSResponse getMeritList() {

		System.out.println("getMeritList run on ctl");

		List<MarksheetDTO> list = baseService.getMeritList(userContext);

		ORSResponse res = new ORSResponse(true);
		res.addResult("list", list);

		return res;
	}
}