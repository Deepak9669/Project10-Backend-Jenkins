package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.SupplierDTO;
import com.rays.form.SupplierForm;
import com.rays.service.SupplierServiceInt;

@RestController
@RequestMapping("Supplier")
public class SupplierCtl extends BaseCtl<SupplierForm, SupplierDTO, SupplierServiceInt> {

}
