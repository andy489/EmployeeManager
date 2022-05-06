package com.fmi.employee.manager.dto;

import com.fmi.employee.manager.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class JobDTOWithId extends JobDTO {
    private final Long id;

    @Builder
    public JobDTOWithId(
            String name,
            String description,
            Integer minSalary,
            List<EmpDTOWithoutInternalCodes> employees,
            String internalCode,
            Long id
    ) {
        super(name, description, minSalary, employees, internalCode);
        this.id = id;
    }
}
