package com.fmi.employee.manager.controller;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
import com.fmi.employee.manager.dto.OrgDTOWithoutEmployees;
import com.fmi.employee.manager.mapper.OrgDTOMapper;
import com.fmi.employee.manager.model.Organization;
import com.fmi.employee.manager.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class OrganizationController {

    private final OrganizationService orgService;
    private final OrgDTOMapper mapper;

    @Autowired
    public OrganizationController(OrganizationService orgService, OrgDTOMapper mapper) {
        this.orgService = orgService;
        this.mapper = mapper;
    }

    @GetMapping("org/template")
    public Organization getJSONTemplate() {
        return new Organization(
                0L,
                "test-name",
                "test-web-site",
                "test-internal-code",
                Collections.emptyList(),
                LocalDateTime.now()
        );
    }

    @PostMapping("org")
    public ResponseEntity<OrgDTOWithId> saveSingleOrg(
            @RequestBody @Valid OrgDTOWithoutEmployees orgDTOWithoutEmployees
    ) {
        return new ResponseEntity<>(orgService.saveOrg(orgDTOWithoutEmployees), HttpStatus.CREATED);
    }

    @PostMapping("orgs")
    public ResponseEntity<List<OrgDTOWithId>> saveMultipleJobs(
            @RequestBody @Valid List<OrgDTOWithoutEmployees> orgDTOWithoutEmployees
    ) {
        return new ResponseEntity<>(orgService.saveAll(orgDTOWithoutEmployees), HttpStatus.CREATED);
    }

    @GetMapping("org")
    public ResponseEntity<List<OrgDTO>> listOrgs() {
        return new ResponseEntity<>(orgService.getAllOrgs(), HttpStatus.OK);
    }

    @GetMapping("org/id/{id}")
    public ResponseEntity<OrgDTOWithId> getOrgById(
            @PathVariable("id") Long orgId
    ) {
        return new ResponseEntity<>(orgService.getOrgById(orgId), HttpStatus.OK);
    }

    @GetMapping("org/code/{code}")
    public ResponseEntity<OrgDTO> getOrgByInternalCode(
            @PathVariable("code") String orgInternalCode
    ) {
        return new ResponseEntity<>(mapper.toDTO(orgService.getOrgByInternalCode(orgInternalCode)), HttpStatus.OK);
    }

    @PatchMapping("org/{id}")
    public ResponseEntity<OrgDTOWithId> partialUpdateOrg(
            @PathVariable("id") Long jobId,
            @RequestBody Map<Object, Object> fields
    ) {
        return new ResponseEntity<>(orgService.partialUpdateOrg(jobId, fields), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/org/{id}")
    public ResponseEntity<String> deleteOrg(
            @PathVariable("id") Long orgId
    ) {
        OrgDTO deletedOrg = orgService.deleteOrg(orgId);
        return new ResponseEntity<>(
                String.format("~Organization \"%s\" with id %d was deleted successfully.",
                        deletedOrg.getName(), orgId
                ), HttpStatus.OK);
    }
}
