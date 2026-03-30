package com.rays.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.rays.dto.UserDTO;

/**
 * Base Controller class that provides common CRUD operations
 * like save, get, delete, and search.
 * 
 * @author Deepak Verma
 *
 * @param <F> Form type extending BaseForm
 * @param <T> DTO type extending BaseDTO
 * @param <S> Service type extending BaseServiceInt
 */
public class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

    /**
     * Base service for performing business operations
     */
    @Autowired
    protected S baseService;

    /**
     * Page size loaded from application properties
     */
    @Value("${page.size}")
    private int pageSize = 0;

    /**
     * Holds current user context
     */
    protected UserContext userContext = null;

    /**
     * Initializes user context before every request
     */
    @ModelAttribute
    public void setUserContext() {
        userContext = UserContextHolder.getContext();
        if (userContext == null) {
            UserDTO dto = new UserDTO();
            dto.setLoginId("root@sunilos.com"); // fallback
            userContext = new UserContext(dto);
        }
    }

    /**
     * Validates form input and returns response with errors if any
     * 
     * @param bindingResult validation result
     * @return ORSResponse containing validation status and errors
     */
    public ORSResponse validate(BindingResult bindingResult) {

        ORSResponse res = new ORSResponse(true);

        if (bindingResult.hasErrors()) {

            res.setSuccess(false);

            Map<String, String> errors = new HashMap<>();

            List<FieldError> list = bindingResult.getFieldErrors();
            list.forEach(e -> {
                errors.put(e.getField(), e.getDefaultMessage());
            });
            res.addInputError(errors);
        }
        return res;
    }

    /**
     * Saves or updates a record based on DTO ID
     * 
     * @param form form object containing DTO data
     * @param bindingResult validation result
     * @return ORSResponse with operation result
     */
    @PostMapping("/save")
    public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }

        T dto = (T) form.getDto();
        
        T existDto = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);

        if (dto.getId() != null && dto.getId() > 0) {


            if (existDto != null && dto.getId() != existDto.getId()) {
                res.setSuccess(false);
                res.addMessage(dto.getLabel() + " already exist");
                return res;
            }

            baseService.update(dto, userContext);
            res.addData(dto.getId());
            res.addMessage(dto.getTableName() + " updated successfully..!!");

        } else {

            if (dto.getUniqueKey() != null && !dto.getUniqueKey().equals("")) {

                if (existDto != null) {
                    res.setSuccess(false);
                    res.addMessage(dto.getLabel() + " already exist");
                    return res;
                }
            }

            Long id = baseService.add(dto, userContext);
            res.addData(id);
            res.setSuccess(true);
            res.addMessage(dto.getTableName() + " added successfully..!!");
        }
        return res;
    }

    /**
     * Retrieves a record by ID
     * 
     * @param id record ID
     * @return ORSResponse containing DTO if found
     */
    @GetMapping("get/{id}")
    public ORSResponse get(@PathVariable long id) {
        ORSResponse res = new ORSResponse(true);
        T dto = baseService.findById(id, userContext);

        if (dto != null) {
            res.addData(dto);
        } else {
            res.setSuccess(false);
            res.addMessage("Record not found");
        }
        return res;
    }

    /**
     * Deletes multiple records by IDs and returns updated list
     * 
     * @param ids array of record IDs
     * @param pageNo current page number
     * @param form search form
     * @return ORSResponse with updated list
     */
    @PostMapping("deleteMany/{ids}")
    public ORSResponse deleteMany(@PathVariable String[] ids,
                                 @RequestParam("pageNo") String pageNo,
                                 @RequestBody F form) {

        ORSResponse res = new ORSResponse(true);

        for (String id : ids) {
            baseService.delete(Long.parseLong(id), userContext);
        }

        T dto = (T) form.getDto();

        List<T> list = baseService.search(dto, Integer.parseInt(pageNo), pageSize, userContext);
        List<T> nextList = baseService.search(dto, Integer.parseInt(pageNo + 1), pageSize, userContext);

        if (list.size() == 0) {
            res.setSuccess(false);
            res.addMessage("Record not found..!!");
        } else {
            res.setSuccess(true);
            res.addMessage("Records Deleted Successfully");
            res.addData(list);
            res.addResult("nextListSize", nextList.size());
        }
        return res;
    }

    /**
     * Searches records with pagination
     * 
     * @param form search form
     * @param pageNo page number
     * @return ORSResponse with search results
     */
    @RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
    public ORSResponse search(@RequestBody F form, @PathVariable int pageNo) {

        pageNo = (pageNo < 0) ? 0 : pageNo;

        T dto = (T) form.getDto();

        ORSResponse res = new ORSResponse(true);

        List<T> list = baseService.search(dto, pageNo, pageSize, userContext);
        List<T> nextList = baseService.search(dto, pageNo + 1, pageSize, userContext);

        if (list.size() == 0) {
            res.setSuccess(false);
            res.addMessage("Record not found..!!");
        } else {
            res.setSuccess(true);
            res.addData(list);
            res.addResult("nextListSize", nextList.size());
        }
        return res;
    }
}