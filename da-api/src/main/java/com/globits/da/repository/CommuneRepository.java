package com.globits.da.repository;

import com.globits.da.domain.employee.Commune;
import com.globits.da.dto.CommuneDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CommuneRepository extends JpaRepository<Commune, UUID> {
    @Query("select count(commune.id) from Commune commune where commune.name =?1 and (commune.id <> ?2 or ?2 is null) ")
    Long checkCode(String code, UUID id);
    @Query("select new com.globits.da.dto.CommuneDto(ed) from Commune ed")
    Page<CommuneDto> getListPage(Pageable pageable);
    @Query("select new com.globits.da.dto.CommuneDto(ed) from Commune ed")
    List<CommuneDto> getAllCommune();
    @Query("select new com.globits.da.dto.CommuneDto(o)FROM Commune o JOIN District d On o.districts.id = d.id ")
    List<CommuneDto> getAllByDistricts();
}
