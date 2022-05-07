package com.fmi.employee.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmi.employee.manager.dto.EmpDTO;
import com.fmi.employee.manager.dto.EmpDTOWithId;
import com.fmi.employee.manager.dto.JobDTO;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String email;
    @Column
    private String phone;

    @Column
    private LocalDateTime hireDate;

    @Column
    private Double salary;
    @Column
    private String topSkill;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization org;
}
