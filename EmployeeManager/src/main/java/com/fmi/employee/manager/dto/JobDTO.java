package com.fmi.employee.manager.dto;

import lombok.Getter;

@Getter
public class JobDTO {
    private String name;
    private String description;
    private Integer minimalSalary;

    public JobDTO(){}

    public JobDTO(String name, String description, Integer minimalSalary) {
        this.name = name;
        this.description = description;
        this.minimalSalary = minimalSalary;
    }
}
