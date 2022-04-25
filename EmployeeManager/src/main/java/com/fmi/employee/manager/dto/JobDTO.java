package com.fmi.employee.manager.dto;

import com.fmi.employee.manager.model.Employee;
import lombok.Getter;

import java.util.List;

@Getter
public class JobDTO {
    private String name;
    private String description;
    private Integer minimalSalary;

    private List<Employee> employees;

    private String internalCode;

    public JobDTO() {
    }

    public JobDTO(
            String name,
            String description,
            Integer minimalSalary,
            String internalCode,
            List<Employee> employees
    ) {
        this.name = name;
        this.description = description;
        this.minimalSalary = minimalSalary;
        this.internalCode = internalCode;
        this.employees = employees;
    }
}
