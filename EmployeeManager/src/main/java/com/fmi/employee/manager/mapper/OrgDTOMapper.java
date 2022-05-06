package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import com.fmi.employee.manager.dto.OrgDTOWithoutEmployees;
import com.fmi.employee.manager.model.Organization;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrgDTOMapper {
    public OrgDTO toDTO(Organization org) {
        return new OrgDTO(org.getName(), org.getWebsite(), org.getInternalCode(), org.getEmployees());
    }

    public Organization toJob(OrgDTO jobDTO) {
        Organization job = new Organization();

        job.update(jobDTO);

        return job;
    }

    public OrgDTOWithId toDTOWithId(Organization org) {
        return new OrgDTOWithId(
                org.getId(),
                org.getName(),
                org.getWebsite(),
                org.getInternalCode(),
                org.getEmployees()
        );
    }

    public OrgDTOWithoutEmployees toOrgDTOWothoutEmployees(Organization org) {
        return new OrgDTOWithoutEmployees(
                org.getName(),
                org.getWebsite(),
                org.getInternalCode()
        );
    }

    public List<OrgDTO> toDTOList(List<Organization> orgList) {
        return orgList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
