package com.fmi.employee.manager.dto;

import lombok.Getter;

@Getter
public class JobDTOWithId extends JobDTO {
    private final Long id;

    public JobDTOWithId(Long id, String name, String description, Integer minimalSalary) {
        super(name, description, minimalSalary);
        this.id = id;
    }
}
