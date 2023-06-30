package com.globits.da.service.impl;

import com.globits.core.service.impl.GenericServiceImpl;
import com.globits.da.domain.myapi.MyFirstApi;
import com.globits.da.dto.MyFirstApiDto;
import com.globits.da.repository.MyFirstApiRepository;
import com.globits.da.service.MyFirstApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MyFirstApiServiceImpl  extends GenericServiceImpl<MyFirstApi, UUID> implements MyFirstApiService{
    @Autowired
    MyFirstApiRepository myFirstApiRepository;

    @Override
    public Page<MyFirstApiDto> getPage(int pageSize, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        return myFirstApiRepository.getListPage(pageable);
    }

    @Override
    public MyFirstApiDto saveOrUpdateMyFirstApi(UUID id, MyFirstApiDto dto) {
        if (dto != null) {
            MyFirstApi myFirstApi = null;
            if (dto.getId() != null) {
                if (dto.getId() != null && !dto.getId().equals(id)) {
                    return null;
                }
                myFirstApi = myFirstApiRepository.getOne(dto.getId());
            }
            if (myFirstApi == null) {
                myFirstApi = new MyFirstApi();
            }
            myFirstApi.setName(dto.getName());
            myFirstApi.setCode(dto.getCode());
            myFirstApi.setAge(dto.getAge());

            myFirstApi = myFirstApiRepository.save(myFirstApi);
            return new MyFirstApiDto(myFirstApi);
        }
        return null;
    }

    @Override
    public Boolean deleteMyFirstApi(UUID id) {
        if (id != null) {
            myFirstApiRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<MyFirstApiDto> getAllMyFirstApi() {
        return myFirstApiRepository.getAllMyFirstApi();
    }

}
