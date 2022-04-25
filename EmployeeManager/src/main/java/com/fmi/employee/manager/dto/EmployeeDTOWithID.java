package com.fmi.employee.manager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EmployeeDTOWithID extends EmployeeDTO {
    private final Long id;

    public EmployeeDTOWithID(
            Long id,
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
        super(firstName,
                lastName,
                email,
                phone,
                hireDate,
                salary,
                topSkill,
                jobCode,
                orgCode
        );
        this.id = id;
    }
}
