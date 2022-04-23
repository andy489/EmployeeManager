package com.fmi.employee.manager.dto;

import com.fmi.employee.manager.model.Employee;
import lombok.Getter;

import java.util.List;

@Getter
public class OrgDTO {
    private String name;
    private String website;
    private List<Employee> employees;

    public OrgDTO() {}

    public OrgDTO(String name, String website, List<Employee> employees) {
        this.name = name;
        this.website = website;
        this.employees = employees;
    }
}
