package com.fmi.employee.manager.model;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
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

@Getter
@Entity
@Table(name = "jobs")
public class Job implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private Integer minimalSalary;

    @Column(unique = true)
    private String internalCode;

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Employee> employees;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Job(Long id,
               String name,
               String description,
               Integer minimalSalary,
               List<Employee> employees,
               String internalCode,
               LocalDateTime timeCreated
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minimalSalary = minimalSalary;
        this.employees = employees;
        this.internalCode = internalCode;
        this.timeCreated = timeCreated;
    }

    public Job() {

    }

    public void update(JobDTO jobDTO) {
        name = jobDTO.getName();
        description = jobDTO.getDescription();
        minimalSalary = jobDTO.getMinimalSalary();
        employees = jobDTO.getEmployees();
        internalCode = jobDTO.getInternalCode();
    }

    public void update(JobDTOWithId jobDTOWithId) {
        id = jobDTOWithId.getId();
        name = jobDTOWithId.getName();
        description = jobDTOWithId.getDescription();
        minimalSalary = jobDTOWithId.getMinimalSalary();
        employees = jobDTOWithId.getEmployees();
        internalCode = jobDTOWithId.getInternalCode();
    }
}
