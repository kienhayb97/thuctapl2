package com.globits.da.rest;

import com.globits.da.AFFakeConstants;
import com.globits.da.dto.CategoryDto;
import com.globits.da.dto.EmployeeDto;
import com.globits.da.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class RestEmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<Page<EmployeeDto>> getPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
        Page<EmployeeDto> results = employeeService.getPage(pageSize, pageIndex);
        return new ResponseEntity<Page<EmployeeDto>>(results, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto dto) {
        EmployeeDto result = employeeService.saveOrUpdateEmployee(null, dto);
        return new ResponseEntity<EmployeeDto>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto dto, @PathVariable UUID id) {
        EmployeeDto result = employeeService.saveOrUpdateEmployee(id, dto);
        return new ResponseEntity<EmployeeDto>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDto>> getAllCategory() {
        List<EmployeeDto> result = employeeService.getAllEmployee();
        return new ResponseEntity<List<EmployeeDto>>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeDto> getList(@PathVariable UUID id) {
        EmployeeDto employeeDto = employeeService.getCertificate(id);
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
    }
    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable UUID id){
        Boolean delete = employeeService.deleteEmployee(id);
        return new ResponseEntity<Boolean>(delete, HttpStatus.OK);
    }
}
