package com.fmi.employee.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrgDTOWithoutEmployees {
    private String name;
    private String website;

    @Pattern(regexp = "^[A-Z]{1,8}$", message = "Internal codes must consist only uppercase characters")
    private String internalCode;
}