package com.fmi.employee.manager.dto;

import lombok.Getter;

@Getter
public class OrgDTOWithId extends OrgDTO{
   private final Long id;

    public OrgDTOWithId(Long id) {
        this.id = id;
    }

    public OrgDTOWithId(Long id, String name, String website) {
        super(name, website);
        this.id = id;
    }
}
