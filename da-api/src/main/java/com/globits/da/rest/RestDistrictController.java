package com.globits.da.rest;

import com.globits.da.dto.DistrictDto;
import com.globits.da.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/district")
public class RestDistrictController {
    @Autowired
    DistrictService districtService;

    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<Page<DistrictDto>> getPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
        Page<DistrictDto> results = districtService.getPage(pageSize, pageIndex);
        return new ResponseEntity<Page<DistrictDto>>(results, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DistrictDto> save(@RequestBody DistrictDto dto) {
        DistrictDto result = districtService.saveOrUpdateDistrict(null, dto);
        return new ResponseEntity<DistrictDto>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DistrictDto> save(@RequestBody DistrictDto dto, @PathVariable UUID id) {
        DistrictDto result = districtService.saveOrUpdateDistrict(id, dto);
        return new ResponseEntity<DistrictDto>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) {
        Boolean delete = districtService.deleteMyDistrict(id);
        return new ResponseEntity<Boolean>(delete, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllDistrict", method = RequestMethod.GET)
    public ResponseEntity<List<DistrictDto>> getAllDistrict() {
        List<DistrictDto> result = districtService.getAllDistrict();
        return new ResponseEntity<List<DistrictDto>>(result, HttpStatus.OK);
    }
}
