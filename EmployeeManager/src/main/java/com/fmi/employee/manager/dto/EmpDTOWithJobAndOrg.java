package com.fmi.employee.manager.dto;

import com.sun.istack.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EmpDTOWithJobAndOrg {
    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private LocalDateTime hireDate;

    private Double salary;
    private String topSkill;

    @NotNull
    private JobDTOWithoutEmployees jobDTOWithoutEmployees;
    @NotNull
    private OrgDTOWithoutEmployees orgDTOWithoutEmployees;

    public EmpDTOWithJobAndOrg() {
    }

    public EmpDTOWithJobAndOrg(
            String firstName,
            String lastName,
            String email,
            String phone,
            LocalDateTime hireDate,
            Double salary,
            String topSkill,
            JobDTOWithoutEmployees jobDTOWithoutEmployees,
            OrgDTOWithoutEmployees orgDTOWithoutEmployees
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.salary = salary;
        this.topSkill = topSkill;

        this.jobDTOWithoutEmployees = jobDTOWithoutEmployees;
        this.orgDTOWithoutEmployees = orgDTOWithoutEmployees;
    }
}
