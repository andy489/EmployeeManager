package com.fmi.employee.manager.dto;

import lombok.Getter;

@Getter
public class OrgDTO {
    private String name;
    private String website;

    public OrgDTO(){}

    public OrgDTO(String name, String website) {
        this.name = name;
        this.website = website;
    }
}
