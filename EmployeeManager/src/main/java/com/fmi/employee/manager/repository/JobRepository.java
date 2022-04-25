package com.fmi.employee.manager.repository;

import com.fmi.employee.manager.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findJobByInternalCode(String internalCode);
}
