package com.fmi.employee.manager.service.impl;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import com.fmi.employee.manager.dto.OrgDTOWithoutEmployees;
import com.fmi.employee.manager.exception.ResourceNotFoundException;
import com.fmi.employee.manager.mapper.OrgDTOMapper;
import com.fmi.employee.manager.model.Organization;
import com.fmi.employee.manager.repository.OrganizationRepository;
import com.fmi.employee.manager.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository orgRepo;

    private final OrgDTOMapper mapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository orgRepo, OrgDTOMapper mapper) {
        this.orgRepo = orgRepo;
        this.mapper = mapper;
    }

    @Override
    public OrgDTOWithId saveOrg(OrgDTOWithoutEmployees orgDTOWithoutEmployees) {
        return mapper.toDTOWithId(orgRepo.save(mapper.toOrg(orgDTOWithoutEmployees)));
    }

    @Override
    public List<OrgDTOWithId> saveAll(List<OrgDTOWithoutEmployees> orgDTOsWithoutEmployees) {
        final int SIZE = orgDTOsWithoutEmployees.size();

        List<Organization> toAdd = orgDTOsWithoutEmployees.stream()
                .limit(SIZE).map(mapper::toOrg).collect(Collectors.toList());

        return orgRepo.saveAll(toAdd).stream().map(mapper::toDTOWithId).collect(Collectors.toList());
    }

    @Override
    public List<OrgDTO> getAllOrgs() {
        return mapper.toDTOList(orgRepo.findAll());
    }

    @Override
    public OrgDTOWithId getOrgById(Long id) {
        Optional<Organization> existingOrg = orgRepo.findById(id);

        if (existingOrg.isPresent()) {
            return mapper.toDTOWithId(existingOrg.get());
        }

        throw new ResourceNotFoundException("Organization", "Id", id);
    }

    @Override
    public Organization getOrgByInternalCode(String internalCode) {
        Optional<Organization> orgByInternalCode = orgRepo.findOrgByInternalCode(internalCode);

        if(orgByInternalCode.isPresent()){
            return orgByInternalCode.get();
        }

        throw new ResourceNotFoundException("Organization", "Internal Code", internalCode);
    }

    @Override
    public OrgDTOWithId partialUpdateOrg(Long id, Map<Object, Object> fields) {
        Optional<Organization> org = orgRepo.findById(id);

        if (org.isEmpty()) {
            throw new ResourceNotFoundException("Organization", "Id", id);
        }

        Organization orgToUpdate = org.get();

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Organization.class, (String) key);

            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field, orgToUpdate, value);
        });

        return mapper.toDTOWithId(orgRepo.save(orgToUpdate));
    }

    @Override
    public OrgDTO deleteOrg(Long id) {
        Organization orgToDelete = orgRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organization", "Id", id));
        orgRepo.deleteById(id);

        return mapper.toDTO(orgToDelete);
    }
}
