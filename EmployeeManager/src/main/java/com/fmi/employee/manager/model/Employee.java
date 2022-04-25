package com.fmi.employee.manager.model;

import com.fmi.employee.manager.dto.EmployeeDTO;
import com.fmi.employee.manager.dto.EmployeeDTOWithID;
import lombok.Getter;
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

    public void update(EmployeeDTO employeeDTO) {
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

    public void update(EmployeeDTOWithID employeeDTOWithID) {
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
