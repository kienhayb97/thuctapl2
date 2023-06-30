package com.globits.da.domain.employee;

import com.globits.core.domain.BaseObject;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "employee")
@XmlRootElement
@Getter
@Setter
public class Employee extends BaseObject {
    private static final long serialVersionUID = 1L;
    @UniqueElements
    @NotBlank
    @Column(name = "code")
    private String code;
    @NotBlank
    @Column(name = "name")
    private String name;
    @Email
    @NotBlank
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "phone")
    @Size(max = 11)
    private String phone;
    @NotNull
    @Column(name = "age")
    @Min(0)
    private Integer age;
}
