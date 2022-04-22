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

    public JobDTO() {

    }

    public JobDTO(
            String name,
            String description,
            Integer minimalSalary,
            List<Employee> employees
    ) {
        this.name = name;
        this.description = description;
        this.minimalSalary = minimalSalary;
        this.employees = employees;
    }
}
