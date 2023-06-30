package com.globits.da.service.impl;

import com.globits.core.service.impl.GenericServiceImpl;
import com.globits.da.domain.employee.Commune;
import com.globits.da.domain.employee.Employee;
import com.globits.da.dto.CommuneDto;
import com.globits.da.repository.CommuneRepository;
import com.globits.da.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CommuneServiceImpl extends GenericServiceImpl<Employee, UUID> implements CommuneService {
    @Autowired
    CommuneRepository communeRepository;
    @Override
    public Page<CommuneDto> getPage(int pageSize, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        return communeRepository.getListPage(pageable);
    }

    @Override
    public CommuneDto saveOrUpdateCommune(UUID id, CommuneDto dto) {
        if (dto != null) {
            Commune commune = null;
            if (dto.getId() != null) {
                if (dto.getId() != null && !dto.getId().equals(id)) {
                    return null;
                }
                commune = communeRepository.getOne(dto.getId());
            }
            if (commune == null) {
                commune = new Commune();
            }
            commune.setName(dto.getName());
//            commune.setDistricts((District) dto.getDistricts());

            commune = communeRepository.save(commune);
            return new CommuneDto(commune);
        }
        return null;
    }

    @Override
    public Boolean deleteMyCommune(UUID id) {
        if (id != null) {
            communeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CommuneDto> getAllCommune() {
        return communeRepository.getAllCommune();
    }
}
