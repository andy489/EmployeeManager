package com.fmi.employee.manager.dto;

import com.fmi.employee.manager.model.Employee;
import lombok.Getter;

import java.util.List;

@Getter
public class OrgDTOWithId extends OrgDTO{
   private final Long id;

    public OrgDTOWithId(Long id, String name, String website, List<Employee> employees, String internalCode) {
        super(name, website, employees, internalCode);
        this.id = id;
    }
}
