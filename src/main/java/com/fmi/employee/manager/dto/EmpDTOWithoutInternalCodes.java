package com.fmi.employee.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDTOWithoutInternalCodes {
    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private LocalDateTime hireDate;

    private Double salary;
    private String topSkill;
}
