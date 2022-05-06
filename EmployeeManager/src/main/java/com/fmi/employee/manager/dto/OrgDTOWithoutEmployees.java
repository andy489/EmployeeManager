package com.fmi.employee.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class OrgDTOWithoutEmployees implements Serializable {
    private static final long serialVersionUID = 3L;

    private String name;
    private String website;

    private String internalCode;

    public OrgDTOWithoutEmployees() {}

    public OrgDTOWithoutEmployees(String name, String website, String internalCode) {
        this.name = name;
        this.website = website;
        this.internalCode = internalCode;
    }
}
