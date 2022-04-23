package com.fmi.employee.manager.service;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;

import java.util.List;
import java.util.Map;

public interface JobService {
    JobDTOWithId saveJob(JobDTO jobDTO);

    List<JobDTOWithId> saveAll(List<JobDTO> jobDTO);

    List<JobDTO> getAllJobs();

    JobDTOWithId getJobById(Long id);

    List<JobDTO> getJobsWithKeywords(String... keywords);

    List<JobDTO> getJobsWithMinSalaryAtLeast(Integer minSalary);

    Double getAverageMinJobSalary();

    JobDTOWithId partialUpdateJob(Long id, Map<Object, Object> fields);

    JobDTOWithId updateJob(JobDTOWithId jobDTOWithId);

    void deleteJob(Long id);
}
