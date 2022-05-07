package com.fmi.employee.manager.dto;

import com.fmi.employee.manager.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrgDTOWithId extends OrgDTO {
    private final Long id;

    @Builder
    public OrgDTOWithId(
            Long id,
            String name,
            String website,
            String internalCode,
            List<EmpDTOWithoutInternalCodes> employees
    ) {
        super(name, website, employees, internalCode);
        this.id = id;
    }
}
