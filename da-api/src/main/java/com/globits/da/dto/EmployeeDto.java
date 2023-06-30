package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.employee.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto extends BaseObjectDto {
    private String code;
    private String name;
    private String email;
    private String phone;
    private Integer age;

    public EmployeeDto() {
        super();
    }

    public EmployeeDto(Employee employee) {
        if (employee != null){
            this.setId(employee.getId());
            this.code = employee.getCode();
            this.name = employee.getName();
            this.email = employee.getEmail();
            this.phone = employee.getPhone();
            this.age = employee.getAge();
        }
    }

}
