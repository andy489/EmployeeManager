package com.fmi.employee.manager.dto;

import com.sun.istack.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EmployeeDTO {
    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private LocalDateTime hireDate;

    private Double salary;
    private String topSkill;

    @NotNull
    private String jobCode;
    @NotNull
    private String orgCode;

    public EmployeeDTO() {}

    public EmployeeDTO(
            String firstName,
            String lastName,
            String email,
            String phone,
            LocalDateTime hireDate,
            Double salary,
            String topSkill,
            String jobCode,
            String orgCode
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.salary = salary;
        this.topSkill = topSkill;
        this.jobCode = jobCode;
        this.orgCode = orgCode;
    }
}
