package com.fmi.employee.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmi.employee.manager.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrgDTO {
    private String name;
    private String website;

    @JsonIgnoreProperties(value = {"org", "job"})
    private List<EmpDTOWithoutInternalCodes> employees;

    private String internalCode;
}
