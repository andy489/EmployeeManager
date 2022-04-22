package com.fmi.employee.manager.repository;

import com.fmi.employee.manager.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
