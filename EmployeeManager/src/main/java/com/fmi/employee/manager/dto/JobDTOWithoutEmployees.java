package com.fmi.employee.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTOWithoutEmployees {
    private String name;
    private String description;

    @Min(750)
    private Integer minimalSalary;

    @Pattern(regexp = "^[A-Z]{1,8}$", message = "Internal codes must consist only uppercase characters")
    private String internalCode;
}

