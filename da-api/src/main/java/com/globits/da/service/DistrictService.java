package com.globits.da.service;

import com.globits.da.dto.DistrictDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface DistrictService {
    public Page<DistrictDto> getPage(int pageSize, int pageIndex);
    public DistrictDto saveOrUpdateDistrict(UUID id, DistrictDto dto);
    public Boolean deleteMyDistrict(UUID id);
    public List<DistrictDto> getAllDistrict();
}
