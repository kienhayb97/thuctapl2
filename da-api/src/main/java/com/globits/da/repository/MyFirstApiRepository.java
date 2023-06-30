package com.globits.da.repository;

import com.globits.da.domain.myapi.MyFirstApi;
import com.globits.da.dto.EmployeeDto;
import com.globits.da.dto.MyFirstApiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MyFirstApiRepository extends JpaRepository<MyFirstApi, UUID> {
    @Query("select count(myFirstApi.id) from MyFirstApi myFirstApi where myFirstApi.code =?1 and (myFirstApi.id <> ?2 or ?2 is null) ")
    Long checkCode(String code, UUID id);
    @Query("select new com.globits.da.dto.MyFirstApiDto(ed) from MyFirstApi ed")
    Page<MyFirstApiDto> getListPage(Pageable pageable);

    @Query("select new com.globits.da.dto.MyFirstApiDto(ed) from MyFirstApi ed")
    List<MyFirstApiDto> getAllMyFirstApi();

}
