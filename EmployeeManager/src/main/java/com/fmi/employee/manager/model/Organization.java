package com.fmi.employee.manager.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name ="organization")
public class Organization {

    @Id
    @Column(name="id", nullable=false)
    private Long id;
    private String name;
    private String website;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Organization(){}

    public Organization(Long id, String name, String website, LocalDateTime timeCreated) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.timeCreated = timeCreated;
    }
}
