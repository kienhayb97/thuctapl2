package com.globits.da.domain.myapi;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Var;

import javax.persistence.*;

@Entity
@Table(name = "myFirstApi")
@Getter
@Setter
public class MyFirstApi extends BaseObject {
    private static final long serialVersionUID = 1L;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
}
