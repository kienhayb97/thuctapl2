package com.globits.da.service;

import com.globits.da.dto.EmployeeDto;
import com.globits.da.dto.MyFirstApiDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface MyFirstApiService {
    public Page<MyFirstApiDto> getPage(int pageSize, int pageIndex);
    public MyFirstApiDto saveOrUpdateMyFirstApi(UUID id, MyFirstApiDto dto);
    public Boolean deleteMyFirstApi(UUID id);
    public List<MyFirstApiDto> getAllMyFirstApi();
}
