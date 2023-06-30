package com.globits.da.rest;

import com.globits.da.dto.ProvinceDto;
import com.globits.da.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/province")
public class RestProvinceController {
    @Autowired
    ProvinceService provinceService;
    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<Page<ProvinceDto>> getPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
        Page<ProvinceDto> results = provinceService.getPage(pageSize, pageIndex);
        return new ResponseEntity<Page<ProvinceDto>>(results, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProvinceDto> save(@RequestBody ProvinceDto dto) {
        ProvinceDto result = provinceService.saveOrUpdateProvince(null, dto);
        return new ResponseEntity<ProvinceDto>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProvinceDto> save(@RequestBody ProvinceDto dto, @PathVariable UUID id) {
        ProvinceDto result = provinceService.saveOrUpdateProvince(id, dto);
        return new ResponseEntity<ProvinceDto>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) {
        Boolean delete = provinceService.deleteMyProvince(id);
        return new ResponseEntity<Boolean>(delete, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllProvince", method = RequestMethod.GET)
    public ResponseEntity<List<ProvinceDto>> getAllDistrict() {
        List<ProvinceDto> result = provinceService.getAllProvince();
        return new ResponseEntity<List<ProvinceDto>>(result, HttpStatus.OK);
    }
}
