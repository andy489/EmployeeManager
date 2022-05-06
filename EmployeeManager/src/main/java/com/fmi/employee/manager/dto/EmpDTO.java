package com.fmi.employee.manager.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
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
}
