package com.globits.da.service;

import com.globits.da.dto.CommuneDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface CommuneService {
    public Page<CommuneDto> getPage(int pageSize, int pageIndex);
    public CommuneDto saveOrUpdateCommune(UUID id, CommuneDto dto);
    public Boolean deleteMyCommune(UUID id);
    public List<CommuneDto> getAllCommune();
}
