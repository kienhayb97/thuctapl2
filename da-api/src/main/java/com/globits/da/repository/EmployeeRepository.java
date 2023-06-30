package com.globits.da.repository;

import com.globits.da.domain.employee.Employee;
import com.globits.da.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query("select count(employee.id) from Employee employee where employee.code =?1 and (employee.id <> ?2 or ?2 is null) ")
    Long checkCode(String code, UUID id);
    @Query("select new com.globits.da.dto.EmployeeDto(ed) from Employee ed")
    Page<EmployeeDto> getListPage(Pageable pageable);

    @Query("select new com.globits.da.dto.EmployeeDto(ed) from Employee ed")
    List<EmployeeDto> getAllEmployee();


    Employee findOneByCode(String code);
}
