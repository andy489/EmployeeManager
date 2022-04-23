package com.fmi.employee.manager.service;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;

import java.util.List;

public interface JobService {
    JobDTOWithId saveJob(JobDTO jobDTO);

    List<JobDTOWithId> saveAll(List<JobDTO> jobDTO);

    List<JobDTO> getAllJobs();

    JobDTOWithId getJobById(Long id);

    List<JobDTO> getJobsWithKeywords(String... keywords);

    List<JobDTO> getJobsWithMinSalaryAtLeast(Integer minSalary);

    Double getAverageMinimalJobSalary();

    JobDTOWithId updateJob(JobDTO jovDTO, Long id);

    void deleteJob(Long id);
}
