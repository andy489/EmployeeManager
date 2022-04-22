package com.fmi.employee.manager.model;

import com.fmi.employee.manager.dto.JobDTO;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "jobs")
public class Job implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private Integer minimalSalary;
    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Job(Long id, String name, String description, Integer minimalSalary, LocalDateTime timeCreated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minimalSalary = minimalSalary;
        this.timeCreated = timeCreated;
    }

    public Job() {

    }

    public void update(JobDTO jobDTO) {
        name = jobDTO.getName();
        description = jobDTO.getDescription();
        minimalSalary = jobDTO.getMinimalSalary();
    }
}
