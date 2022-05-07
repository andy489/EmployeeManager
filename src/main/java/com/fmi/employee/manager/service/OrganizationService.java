package com.fmi.employee.manager.service;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import com.fmi.employee.manager.dto.OrgDTOWithoutEmployees;
import com.fmi.employee.manager.model.Organization;

import java.util.List;
import java.util.Map;

public interface OrganizationService {
    OrgDTOWithId saveOrg(OrgDTOWithoutEmployees orgDTOWithoutEmployees);

    List<OrgDTOWithId> saveAll(List<OrgDTOWithoutEmployees> orgDTOsWithoutEmployees);

    List<OrgDTO> getAllOrgs();

    OrgDTOWithId getOrgById(Long id);

    Organization getOrgByInternalCode(String internalCode);

    OrgDTOWithId partialUpdateOrg(Long id, Map<Object, Object> fields);

    OrgDTO deleteOrg(Long id);
}
