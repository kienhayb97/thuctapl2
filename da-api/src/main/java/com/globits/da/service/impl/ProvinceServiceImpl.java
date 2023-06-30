package com.globits.da.service.impl;

import com.globits.core.service.impl.GenericServiceImpl;
import com.globits.da.domain.employee.Commune;
import com.globits.da.domain.employee.Province;
import com.globits.da.dto.CommuneDto;
import com.globits.da.dto.ProvinceDto;
import com.globits.da.repository.ProvinceRepository;
import com.globits.da.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProvinceServiceImpl extends GenericServiceImpl<Province, UUID> implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public Page<ProvinceDto> getPage(int pageSize, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        return provinceRepository.getListPage(pageable);
    }

    @Override
    public ProvinceDto saveOrUpdateProvince(UUID id, ProvinceDto dto) {
        if (dto != null) {
            Province province = null;
            if (dto.getId() != null) {
                if (dto.getId() != null && !dto.getId().equals(id)) {
                    return null;
                }
                province = provinceRepository.getOne(dto.getId());
            }
            if (province == null) {
                province = new Province();
            }
            province.setName(dto.getName());
//            commune.setDistricts((District) dto.getDistricts());

            province = provinceRepository.save(province);
            return new ProvinceDto(province);
        }
        return null;
    }

    @Override
    public Boolean deleteMyProvince(UUID id) {
        if (id != null) {
            provinceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ProvinceDto> getAllProvince() {
        return provinceRepository.getAllProvince();
    }
}
