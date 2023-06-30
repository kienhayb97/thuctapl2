package com.globits.da.domain.employee;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "province")
@Getter
@Setter
public class Province extends BaseObject {
    private static final long serialVersionUID = 1L;
    @Column(name = "code_province")
    private String code;
    @Column(name = "name_province")
    private String name;
//    @OneToMany(mappedBy = "district")
//    private Set<District> districts;
}
