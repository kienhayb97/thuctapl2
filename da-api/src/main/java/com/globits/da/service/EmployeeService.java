package com.globits.da.service;

import com.globits.core.service.GenericService;
import com.globits.da.domain.employee.Employee;
import com.globits.da.dto.EmployeeDto;
import com.globits.da.dto.search.SearchDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
@Service
public interface EmployeeService extends GenericService<Employee, UUID> {
    public Page<EmployeeDto> getPage(int pageSize, int pageIndex);
    public EmployeeDto saveOrUpdateEmployee(UUID id,EmployeeDto dto);
    public Boolean deleteEmployee(UUID id);
    public EmployeeDto getCertificate(UUID id);
    Page<EmployeeDto> searchByPage(SearchDto dto);
    Boolean checkCode (UUID id,String code);
    public List<EmployeeDto> getAllEmployee();
    public Boolean deleteCheckById(UUID id);
}
