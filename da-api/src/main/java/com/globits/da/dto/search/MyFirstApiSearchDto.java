package com.globits.da.dto.search;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Setter
@Getter
public class MyFirstApiSearchDto {
    private UUID id;
    private int pageIndex;
    private int pageSize;
    private String keyword;
    private Boolean voided;
    private UUID khoId;
    private String orderBy;
    private String text;
    private UUID productMyFirstApi;
    private Date fromDate;
    private Date toDate;
}
