package com.globits.da.domain.employee;

import com.globits.core.domain.BaseObject;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "district")
@XmlRootElement
@Setter
@Getter
public class District extends BaseObject {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Column(name = "code_district")
    private String code;
    @Column(name = "name_district")
    private String name;
    //@Column(name = "district_id")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "communes_id")
    private Set<District> Communes;
//    @Column(name = "province_id")
//    @ManyToOne
//    private Province provinces;
}
