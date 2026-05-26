package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.InventoryDTO;
import com.rays.form.InventoryForm;
import com.rays.service.InventoryServiceInt;


@RestController
@RequestMapping("Inventory")
public class InventoryCtl extends BaseCtl<InventoryForm, InventoryDTO, InventoryServiceInt>{

}
