package com.fmi.employee.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class EmpDTOWithId {
    private final Long id;

    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private LocalDateTime hireDate;

    private Double salary;
    private String topSkill;

    @JsonIgnoreProperties(value = "employees")
    private JobDTO jobDTO;

    @JsonIgnoreProperties(value = "employees")
    private OrgDTO orgDTO;
}
