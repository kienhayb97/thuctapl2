package com.globits.da.rest;

import com.globits.da.dto.CommuneDto;
import com.globits.da.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/commune")
public class RestCommuneController {
    @Autowired
    CommuneService communeService;

    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<Page<CommuneDto>> getPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
        Page<CommuneDto> results = communeService.getPage(pageSize, pageIndex);
        return new ResponseEntity<Page<CommuneDto>>(results, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommuneDto> save(@RequestBody CommuneDto dto) {
        CommuneDto result = communeService.saveOrUpdateCommune(null, dto);
        return new ResponseEntity<CommuneDto>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommuneDto> save(@RequestBody CommuneDto dto, @PathVariable UUID id) {
        CommuneDto result = communeService.saveOrUpdateCommune(id, dto);
        return new ResponseEntity<CommuneDto>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) {
        Boolean delete = communeService.deleteMyCommune(id);
        return new ResponseEntity<Boolean>(delete, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllCommune", method = RequestMethod.GET)
    public ResponseEntity<List<CommuneDto>> getAllCommune() {
        List<CommuneDto> result = communeService.getAllCommune();
        return new ResponseEntity<List<CommuneDto>>(result, HttpStatus.OK);
    }
}
