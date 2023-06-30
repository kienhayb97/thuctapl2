package com.globits.da.service.impl;

import com.globits.core.service.impl.GenericServiceImpl;
import com.globits.da.domain.employee.Employee;
import com.globits.da.dto.EmployeeDto;
import com.globits.da.dto.search.SearchDto;
import com.globits.da.repository.EmployeeRepository;
import com.globits.da.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, UUID> implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<EmployeeDto> getPage(int pageSize, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        return employeeRepository.getListPage(pageable);
    }

    @Override
    public EmployeeDto saveOrUpdateEmployee(UUID id, EmployeeDto dto) {
        if (dto != null) {
            Employee employee = null;
            if (dto.getId() != null) {
                if (dto.getId() != null && !dto.getId().equals(id)) {
                    return null;
                }
                employee = employeeRepository.getOne(dto.getId());
            }
            if (employee == null) {
                employee = new Employee();
            }
            employee.setName(dto.getName());
            employee.setCode(dto.getCode());
            employee.setEmail(dto.getEmail());
            employee.setPhone(dto.getPhone());
            employee.setAge(dto.getAge());

            employee = employeeRepository.save(employee);
            return new EmployeeDto(employee);
        }
        return null;
    }

    @Override
    public Boolean deleteEmployee(UUID id) {
        if (id != null) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public EmployeeDto getCertificate(UUID id) {
        Employee employee = employeeRepository.getOne(id);
        return new EmployeeDto(employee);
    }

    @Override
    public Page<EmployeeDto> searchByPage(SearchDto dto) {
        if (dto == null) {
            return null;
        }

        int pageIndex = dto.getPageIndex();
        int pageSize = dto.getPageSize();

        if (pageIndex > 0) {
            pageIndex--;
        } else {
            pageIndex = 0;
        }

        String whereClause = "";

        String orderBy = " ORDER BY entity.createDate DESC";

        String sqlCount = "select count(entity.id) from  Employee as entity where (1=1)   ";
        String sql = "select new com.globits.da.dto.EmployeeDto(entity) from  Employee as entity where (1=1)  ";

        if (dto.getKeyword() != null && StringUtils.hasText(dto.getKeyword())) {
            whereClause += " AND ( ORemployee.code LIKE :text OR entity.name LIKE :text OR entity.email LIKE :text OR entity.phone LIKE :text entity.age LIKE :text)";
        }


        sql += whereClause + orderBy;
        sqlCount += whereClause;

        Query q = manager.createQuery(sql, EmployeeDto.class);
        Query qCount = manager.createQuery(sqlCount);

        if (dto.getKeyword() != null && StringUtils.hasText(dto.getKeyword())) {
            q.setParameter("text", '%' + dto.getKeyword() + '%');
            qCount.setParameter("text", '%' + dto.getKeyword() + '%');
        }
        int startPosition = pageIndex * pageSize;
        q.setFirstResult(startPosition);
        q.setMaxResults(pageSize);
        List<EmployeeDto> entity = q.getResultList();
        long count = (long) qCount.getSingleResult();

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        return new PageImpl<EmployeeDto>(entity, pageable, count);

    }

    @Override
    public Boolean checkCode(UUID id, String code) {
        if(StringUtils.hasText(code)) {
            Long count = employeeRepository.checkCode(code,id);
            return count != 0L;
        }
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public Boolean deleteCheckById(UUID id) {
        return null;
    }
}
