package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import com.fmi.employee.manager.dto.OrgDTOWithoutEmployees;
import com.fmi.employee.manager.model.Organization;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrgDTOMapper {

    public OrgDTO toDTO(Organization org) {
        return new OrgDTO(
                org.getName(),
                org.getWebsite(),
                EmployeeMapperHelper.empDTOWithoutInternalCodesList(org.getEmployees()),
                org.getInternalCode()
        );
    }

    public Organization toOrg(OrgDTOWithId orgDTOWithId) {
        return Organization.builder()
                .name(orgDTOWithId.getName())
                .website((orgDTOWithId.getWebsite()))
                .internalCode(orgDTOWithId.getInternalCode())
                .employees(Collections.emptyList())
                .build();
    }

    public Organization toOrg(OrgDTOWithoutEmployees orgDTOWithoutEmployees) {
        return Organization.builder()
                .name(orgDTOWithoutEmployees.getName())
                .website((orgDTOWithoutEmployees.getWebsite()))
                .internalCode(orgDTOWithoutEmployees.getInternalCode())
                .employees(Collections.emptyList())
                .build();
    }

    public OrgDTOWithId toDTOWithId(Organization org) {
        return OrgDTOWithId.builder()
                .id(org.getId())
                .name(org.getName())
                .website(org.getWebsite())
                .internalCode(org.getInternalCode())
                .employees(EmployeeMapperHelper.empDTOWithoutInternalCodesList(org.getEmployees()))
                .build();
    }

    public List<OrgDTO> toDTOList(List<Organization> orgList) {
        return orgList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
