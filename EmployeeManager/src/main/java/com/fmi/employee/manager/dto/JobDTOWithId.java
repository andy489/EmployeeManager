package com.fmi.employee.manager.dto;

import com.fmi.employee.manager.model.Employee;
import lombok.Getter;

import java.util.List;

@Getter
public class JobDTOWithId extends JobDTO {
    private final Long id;

    public JobDTOWithId(
            Long id,
            String name,
            String description,
            Integer minimalSalary,
            List<Employee> employees,
            String internalCode
    ) {
        super(name, description, minimalSalary, employees, internalCode);
        this.id = id;
    }
}
