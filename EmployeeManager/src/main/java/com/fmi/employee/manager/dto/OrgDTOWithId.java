package com.fmi.employee.manager.dto;

import com.fmi.employee.manager.model.Employee;
import lombok.Getter;

import java.util.List;

@Getter
public class OrgDTOWithId extends OrgDTO {
    private final Long id;

    public OrgDTOWithId(Long id, String name, String website, String internalCode, List<Employee> employees) {
        super(name, website, internalCode, employees);
        this.id = id;
    }
}
