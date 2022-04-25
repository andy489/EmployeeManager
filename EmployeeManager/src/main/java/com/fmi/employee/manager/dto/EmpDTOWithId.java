package com.fmi.employee.manager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EmpDTOWithId {
    private final Long id;

    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private LocalDateTime hireDate;

    private Double salary;
    private String topSkill;

    private JobDTO jobDTO;
    private OrgDTO orgDTO;

    public EmpDTOWithId(
            Long id,
            String firstName,
            String lastName,
            String email,
            String phone,
            LocalDateTime hireDate,
            Double salary,
            String topSkill,
            JobDTO jobDTO,
            OrgDTO orgDTO
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.salary = salary;
        this.topSkill = topSkill;
        this.jobDTO = jobDTO;
        this.orgDTO = orgDTO;
    }
}
