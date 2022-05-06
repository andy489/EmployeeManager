package com.fmi.employee.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrgDTOWithoutEmployees {
    private String name;
    private String website;
    private String internalCode;
}