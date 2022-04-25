package com.fmi.employee.manager.model;

import com.fmi.employee.manager.dto.EmpDTO;
import com.fmi.employee.manager.dto.EmpDTOWithId;
import com.fmi.employee.manager.dto.JobDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private LocalDateTime hireDate;

    private Double salary;
    private String topSkill;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization org;

    public Employee() {
    }

    public Employee(
            Long id,
            String firstName,
            String lastName,
            String email,
            String phone,
            LocalDateTime hireDate,
            Double salary,
            String topSkill,
            LocalDateTime timeCreated,
            Job job,
            Organization org
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.salary = salary;
        this.topSkill = topSkill;
        this.timeCreated = timeCreated;
        this.job = job;
        this.org = org;
    }

    public void update(EmpDTO employeeDTO) {
        firstName = employeeDTO.getFirstName();
        lastName = employeeDTO.getLastName();
        email = employeeDTO.getEmail();
        phone = employeeDTO.getPhone();
        hireDate = employeeDTO.getHireDate();
        salary = employeeDTO.getSalary();
        topSkill = employeeDTO.getTopSkill();

        // Job job
        // Organization org
    }

    public void update(EmpDTOWithId employeeDTOWithID) {
        id = employeeDTOWithID.getId();
        firstName = employeeDTOWithID.getFirstName();
        lastName = employeeDTOWithID.getLastName();
        email = employeeDTOWithID.getEmail();
        phone = employeeDTOWithID.getPhone();
        hireDate = employeeDTOWithID.getHireDate();
        salary = employeeDTOWithID.getSalary();
        topSkill = employeeDTOWithID.getTopSkill();

        // Job job
        // Organization org
    }
}
