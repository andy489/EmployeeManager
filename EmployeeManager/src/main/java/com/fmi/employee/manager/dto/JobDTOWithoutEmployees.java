package com.fmi.employee.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmi.employee.manager.model.Employee;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class JobDTOWithoutEmployees implements Serializable {
    private static final long serialVersionUID = 3L;

    private String name;
    private String description;
    private Integer minimalSalary;

    private String internalCode;

    public JobDTOWithoutEmployees() {
    }

    public JobDTOWithoutEmployees(
            String name,
            String description,
            Integer minimalSalary,
            String internalCode
    ) {
        this.name = name;
        this.description = description;
        this.minimalSalary = minimalSalary;
        this.internalCode = internalCode;
    }
}
