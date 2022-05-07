package com.fmi.employee.manager.repository;

import com.fmi.employee.manager.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findOrgByInternalCode(String internalCode);

}
