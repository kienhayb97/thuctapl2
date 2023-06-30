package com.globits.da.domain.employee;

import com.globits.core.domain.BaseObject;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "diplomasAndCertificates")
@XmlRootElement
public class DiplomasAndCertificates extends BaseObject {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Column(name = "name_diplomasAndCertificates")
    private String name;
}
