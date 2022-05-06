package com.fmi.employee.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmi.employee.manager.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private String name;
    private String description;
    private Integer minimalSalary;

    @JsonIgnoreProperties(value = {"job", "org"})
    private List<EmpDTOWithoutInternalCodes> employees;

    private String internalCode;
}
