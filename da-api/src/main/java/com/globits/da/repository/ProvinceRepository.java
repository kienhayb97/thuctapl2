package com.globits.da.repository;

import com.globits.da.domain.employee.Province;
import com.globits.da.dto.EmployeeDto;
import com.globits.da.dto.ProvinceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProvinceRepository extends JpaRepository<Province, UUID> {
    @Query("select count(province.id) from Province province where province.name =?1 and (province.id <> ?2 or ?2 is null) ")
    Long checkCode(String code, UUID id);
    @Query("select new com.globits.da.dto.ProvinceDto(ed) from Province ed")
    Page<ProvinceDto> getListPage(Pageable pageable);

    @Query("select new com.globits.da.dto.ProvinceDto(ed) from Province ed")
    List<ProvinceDto> getAllProvince();
}
