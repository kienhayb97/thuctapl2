package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto extends BaseObjectDto{
	private String name;
	private String code;
	public CategoryDto() {
		super();
	}
	public CategoryDto(Category entity) {
		if(entity != null) {
			this.setId(entity.getId());
			this.code = entity.getCode();
			this.name = entity.getName();
		}
	}
	
}
