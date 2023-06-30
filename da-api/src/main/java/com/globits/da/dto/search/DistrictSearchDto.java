package com.globits.da.dto.search;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class DistrictSearchDto {
    private UUID id;
    private int pageIndex;
    private int pageSize;
    private String keyword;
    private Boolean voided;
    private UUID khoId;
    private String orderBy;
    private String text;
    private UUID productDistrict;
    private Date fromDate;
    private Date toDate;
}
