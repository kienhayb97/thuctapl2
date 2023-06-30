package com.globits.da.repository;


import com.globits.da.domain.employee.Commune;
import com.globits.da.domain.employee.District;
import com.globits.da.dto.DistrictDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DistrictRepository extends JpaRepository<District, UUID> {
    @Query("select count(district.id) from District district where district.name =?1 and (district.id <> ?2 or ?2 is null) ")
    Long checkCode(String code, UUID id);
    @Query("select new com.globits.da.dto.DistrictDto(ed) from District ed")
    Page<DistrictDto> getListPage(Pageable pageable);
    @Query("select new com.globits.da.dto.DistrictDto(ed) from District ed")
    List<DistrictDto> getAllDistrict();
    @Query("select new com.globits.da.dto.DistrictDto(o) FROM District o JOIN Commune d WHERE o.communes = d.id")
    List<DistrictDto> getAllWithCommunes();

}
