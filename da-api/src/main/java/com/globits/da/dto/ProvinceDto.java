package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.employee.District;
import com.globits.da.domain.employee.Province;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.Set;
@Setter
@Getter
public class ProvinceDto extends BaseObjectDto {
    private String name;
//    private Set<District> districts;
    public ProvinceDto(Province province) {
        if (province != null) {
            this.setId(province.getId());
            this.setName(province.getName());
//            this.setDistricts(province.getDistricts());
        }
    }
}
