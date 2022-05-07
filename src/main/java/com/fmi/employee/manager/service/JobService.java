package com.fmi.employee.manager.service;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import com.fmi.employee.manager.dto.JobDTOWithoutEmployees;
import com.fmi.employee.manager.model.Job;

import java.util.List;
import java.util.Map;

public interface JobService {
    JobDTOWithId saveJob(JobDTOWithoutEmployees jobDTOWithoutEmployees);

    List<JobDTOWithId> saveAll(List<JobDTOWithoutEmployees> jobDTOsWithoutEmployees);

    List<JobDTO> getAllJobs();

    JobDTOWithId getJobById(Long id);

    Job getJobByInternalCode(String internalCode);

    List<JobDTO> getJobsWithKeywords(String... keywords);

    List<JobDTO> getJobsWithMinSalaryAtLeast(Integer minSalary);

    Double getAverageMinJobSalary();

    JobDTOWithId partialUpdateJob(Long id, Map<Object, Object> fields);

    JobDTO deleteJob(Long id);
}
