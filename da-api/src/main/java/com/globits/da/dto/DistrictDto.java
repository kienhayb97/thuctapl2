package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.employee.District;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class DistrictDto extends BaseObjectDto {
    private String name;
    private Set<District> communes;
//    private Set<Province> provinces;


    public DistrictDto() {
    }

    public DistrictDto(District district) {
        if (district != null){
            this.setId(district.getId());
            this.setName(district.getName());
            this.setCommunes(district.getCommunes());
//            this.setProvinces((Set<Province>) district.getProvinces());
        }
    }
}
