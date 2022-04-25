package com.fmi.employee.manager.model;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "organizations")
public class Organization implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "org_id", nullable = false)
    private Long id;
    private String name;
    private String website;

    @Column(unique = true)
    private String internalCode;

    @OneToMany(mappedBy = "org", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Employee> employees;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Organization() {
    }

    public Organization(
            Long id,
            String name,
            String website,
            String internalCode,
            List<Employee> employees,
            LocalDateTime timeCreated
    ) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.employees = employees;
        this.internalCode = internalCode;
        this.timeCreated = timeCreated;
    }

    public void update(OrgDTO orgDTO) {
        name = orgDTO.getName();
        website = orgDTO.getWebsite();
        employees = orgDTO.getEmployees();
        internalCode = orgDTO.getInternalCode();
    }

    public void update(OrgDTOWithId orgDTOWithId) {
        id = orgDTOWithId.getId();
        name = orgDTOWithId.getName();
        website = orgDTOWithId.getWebsite();
        employees = orgDTOWithId.getEmployees();
        internalCode = orgDTOWithId.getInternalCode();
    }
}
