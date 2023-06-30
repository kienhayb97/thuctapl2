package com.globits.da.service.impl;

import com.globits.core.service.impl.GenericServiceImpl;
import com.globits.da.domain.employee.District;
import com.globits.da.dto.DistrictDto;
import com.globits.da.repository.DistrictRepository;
import com.globits.da.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class DistrictServiceImpl extends GenericServiceImpl<District, UUID> implements DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public Page<DistrictDto> getPage(int pageSize, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        return districtRepository.getListPage(pageable);
    }

    @Override
    public DistrictDto saveOrUpdateDistrict(UUID id, DistrictDto dto) {
        if (dto != null) {
            District district = null;
            if (dto.getId() != null) {
                if (dto.getId() != null && !dto.getId().equals(id)) {
                    return null;
                }
                district = districtRepository.getOne(dto.getId());
            }
            if (district == null) {
                district = new District();
            }
            district.setName(dto.getName());
//            commune.setDistricts((District) dto.getDistricts());

            district = districtRepository.save(district);
            return new DistrictDto(district);
        }
        return null;
    }

    @Override
    public Boolean deleteMyDistrict(UUID id) {
        if (id != null) {
            districtRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DistrictDto> getAllDistrict() {
        return districtRepository.getAllDistrict();
    }
}
