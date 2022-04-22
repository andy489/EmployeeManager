package com.fmi.employee.manager.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name ="organization")
public class Organization implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long id;
    private String name;
    private String website;

    @OneToMany
    @JoinColumn(name = "organization_id")
    private List<Employee> employees;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Organization(){}

    public Organization(Long id, String name, String website, List<Employee> employees,LocalDateTime timeCreated) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.employees = employees;
        this.timeCreated = timeCreated;
    }
}
