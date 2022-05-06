package com.fmi.employee.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmi.employee.manager.model.Employee;
import lombok.Getter;

import java.util.List;

@Getter
public class OrgDTO {
    private String name;
    private String website;

    @JsonIgnoreProperties(value = "org") // use DTO instead entity
    private List<Employee> employees;

    private String internalCode;

    public OrgDTO() {}

    public OrgDTO(String name, String website, String internalCode, List<Employee> employees) {
        this.name = name;
        this.website = website;
        this.internalCode = internalCode;
        this.employees = employees;
    }
}
