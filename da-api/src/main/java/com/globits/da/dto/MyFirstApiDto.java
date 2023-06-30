package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.myapi.MyFirstApi;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Var;
@Setter
@Getter
public class MyFirstApiDto extends BaseObjectDto{
    private String code;
    private String name;
    private int age;
    public MyFirstApiDto() {
    }
    public MyFirstApiDto(MyFirstApi myFirstApi) {
        if (myFirstApi != null){
            this.setId(myFirstApi.getId());
            this.code = myFirstApi.getCode();
            this.name = myFirstApi.getName();
            this.age = myFirstApi.getAge();
        }
    }

}
