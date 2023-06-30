package com.globits.da.domain.employee;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "communes")
@Setter
@Getter
public class Commune extends BaseObject {
    private static final long serialVersionUID = 1L;
    @Column(name = "code_commune")
    private String code;
    @Column(name = "name_commune")
    private String name;
    @ManyToOne
    @JoinColumn(name = "districts_id")
    private District districts;

}
