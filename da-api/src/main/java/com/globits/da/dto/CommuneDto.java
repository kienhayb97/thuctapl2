package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.employee.Commune;
import com.globits.da.domain.employee.District;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class CommuneDto extends BaseObjectDto {
    private String code;
    private String name;

    private Set<District> districts;

    public CommuneDto() {
    }
    public CommuneDto(Commune commune) {
        if (commune != null){
            this.setId(commune.getId());
            this.setCode(commune.getCode());
            this.setName(commune.getName());
            this.setDistricts((Set<District>) commune.getDistricts());
        }
    }
}
