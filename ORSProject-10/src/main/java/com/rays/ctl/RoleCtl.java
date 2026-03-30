package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

/**
 * RoleCtl is a REST Controller for handling
 * Role related operations.
 * 
 * It extends BaseCtl which provides generic CRUD operations.
 * 
 * This controller also provides a preload API to fetch
 * role list for dropdown usage.
 * 
 * All endpoints are mapped under "/Role".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDTO, RoleServiceInt> {

    /**
     * Preload API to fetch role list
     * 
     * @return ORSResponse containing role list
     */
    @GetMapping("preload")
    public ORSResponse preload() {

        ORSResponse res = new ORSResponse(true);

        RoleDTO dto = new RoleDTO();

        // dto.setStatus(RoleDTO.ACTIVE);

        List<DropdownList> list = baseService.search(dto, userContext);

        res.addResult("roleList", list);

        return res;
    }
}