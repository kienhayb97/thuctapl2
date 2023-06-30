package com.globits.da.service;

import com.globits.da.dto.ProvinceDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface ProvinceService {
    public Page<ProvinceDto> getPage(int pageSize, int pageIndex);
    public ProvinceDto saveOrUpdateProvince(UUID id, ProvinceDto dto);
    public Boolean deleteMyProvince(UUID id);
    public List<ProvinceDto> getAllProvince();
}
