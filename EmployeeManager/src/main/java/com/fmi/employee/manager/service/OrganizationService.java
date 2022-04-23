package com.fmi.employee.manager.service;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;

import java.util.List;
import java.util.Map;

public interface OrganizationService {
    OrgDTOWithId saveOrg(OrgDTO orgDTO);

    List<OrgDTOWithId> saveAll(List<OrgDTO> orgDTOs);

    List<OrgDTO> getAllOrgs();

    OrgDTOWithId getOrgById(Long id);

    OrgDTOWithId partialUpdateOrg(Long id, Map<Object, Object> fields);

    OrgDTOWithId updateOrg(OrgDTOWithId orgDTOWithId);

    void deleteOrg(Long id);
}
