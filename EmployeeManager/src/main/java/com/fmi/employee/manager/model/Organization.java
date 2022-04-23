package com.fmi.employee.manager.model;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "organization")
public class Organization implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String website;

    @OneToMany
    @JoinColumn(name = "organization_id")
    private List<Employee> employees;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Organization() {
    }

    public Organization(Long id, String name, String website, List<Employee> employees, LocalDateTime timeCreated) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.employees = employees;
        this.timeCreated = timeCreated;
    }

    public void update(OrgDTO orgDTO) {
        name = orgDTO.getName();
        website = orgDTO.getWebsite();
        employees = orgDTO.getEmployees();
    }

    public void update(OrgDTOWithId orgDTOWithId) {
        id = orgDTOWithId.getId();
        name = orgDTOWithId.getName();
        website = orgDTOWithId.getWebsite();
        employees = orgDTOWithId.getEmployees();
    }
}
