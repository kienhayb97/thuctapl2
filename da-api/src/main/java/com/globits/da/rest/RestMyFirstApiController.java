package com.globits.da.rest;

import com.globits.da.dto.EmployeeDto;
import com.globits.da.dto.MyFirstApiDto;
import com.globits.da.service.MyFirstApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/myFirstApi")
public class RestMyFirstApiController {
    @Autowired
    private MyFirstApiService myFirstApiService;
    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<Page<MyFirstApiDto>> getPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
        Page<MyFirstApiDto> results = myFirstApiService.getPage(pageSize, pageIndex);
        return new ResponseEntity<Page<MyFirstApiDto>>(results, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<MyFirstApiDto> save(@RequestBody MyFirstApiDto dto) {
        MyFirstApiDto result = myFirstApiService.saveOrUpdateMyFirstApi(null, dto);
        return new ResponseEntity<MyFirstApiDto>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MyFirstApiDto> save(@RequestBody MyFirstApiDto dto, @PathVariable UUID id) {
        MyFirstApiDto result = myFirstApiService.saveOrUpdateMyFirstApi(id, dto);
        return new ResponseEntity<MyFirstApiDto>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/getAllMyFirstApi", method = RequestMethod.GET)
    public ResponseEntity<List<MyFirstApiDto>> getAllFirstApiDto() {
        List<MyFirstApiDto> result = myFirstApiService.getAllMyFirstApi();
        return new ResponseEntity<List<MyFirstApiDto>>(result, HttpStatus.OK);
    }
    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable UUID id){
        Boolean delete = myFirstApiService.deleteMyFirstApi(id);
        return new ResponseEntity<Boolean>(delete, HttpStatus.OK);
    }
}
