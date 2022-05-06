package com.fmi.employee.manager.model;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Integer minimalSalary;

    @Column(unique = true)
    private String internalCode;

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<Employee> employees;

    @Column
    @CreationTimestamp
    private LocalDateTime timeCreated;
}
