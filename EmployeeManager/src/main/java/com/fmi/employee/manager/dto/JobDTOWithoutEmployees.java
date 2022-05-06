package com.fmi.employee.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTOWithoutEmployees {
    private String name;
    private String description;
    private Integer minimalSalary;
    private String internalCode;
}

