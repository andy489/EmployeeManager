package com.fmi.employee.manager.controller;

import com.fmi.employee.manager.dto.OrgDTO;
import com.fmi.employee.manager.dto.OrgDTOWithId;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class OrganizationController {

    private final OrganizationService orgService;

    @Autowired
    public OrganizationController(OrganizationService orgService) {
        this.orgService = orgService;
    }

    @GetMapping("org/template")
    public Organization getJSONTemplate() {
        return new Organization(
                0L,
                "test-name",
                "test-web-site",
                Collections.emptyList(),
                LocalDateTime.now()
        );
    }

    @PostMapping("org")
    public ResponseEntity<OrgDTOWithId> saveSingleOrg(@RequestBody OrgDTO orgDTO) {
        return new ResponseEntity<>(orgService.saveOrg(orgDTO), HttpStatus.CREATED);
    }

    @PostMapping("orgs")
    public ResponseEntity<List<OrgDTOWithId>> saveMultipleJobs(@RequestBody List<OrgDTO> orgDTO) {
        return new ResponseEntity<>(orgService.saveAll(orgDTO), HttpStatus.CREATED);
    }

    @GetMapping("org")
    public ResponseEntity<List<OrgDTO>> listOrgs() {
        return new ResponseEntity<>(orgService.getAllOrgs(), HttpStatus.OK);
    }

    @GetMapping("org/id/{id}")
    public ResponseEntity<OrgDTOWithId> getOrgById(@PathVariable("id") Long orgId) {
        return new ResponseEntity<>(orgService.getOrgById(orgId), HttpStatus.OK);
    }

    @PatchMapping("org/{id}")
    public ResponseEntity<OrgDTOWithId> partialUpdateOrg(
            @PathVariable("id") Long jobId,
            @RequestBody Map<Object, Object> fields
    ) {
        return new ResponseEntity<>(orgService.partialUpdateOrg(jobId, fields), HttpStatus.OK);
    }

    @PutMapping("org")
    public ResponseEntity<OrgDTOWithId> updateOrg(@RequestBody OrgDTOWithId jobDTOWithId) {
        return new ResponseEntity<>(orgService.updateOrg(jobDTOWithId), HttpStatus.OK);
    }

    @DeleteMapping("/org/{id}")
    public ResponseEntity<String> deleteOrg(@PathVariable("id") Long orgId) {
        orgService.deleteOrg(orgId);
        return new ResponseEntity<>(String.format("~Job with id %d was deleted successfully.", orgId), HttpStatus.OK);
    }
}
