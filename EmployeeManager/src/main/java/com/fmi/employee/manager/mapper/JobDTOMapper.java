package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import com.fmi.employee.manager.dto.JobDTOWithoutEmployees;
import com.fmi.employee.manager.model.Job;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobDTOMapper {
    public JobDTO toDTO(Job job) {
        return new JobDTO(
                job.getName(),
                job.getDescription(),
                job.getMinimalSalary(),
                EmployeeMapperHelper.empDTOWithoutInternalCodesList(job.getEmployees()),
                job.getInternalCode()
        );
    }

    public Job toJob(JobDTO jobDTO) {
        return Job.builder()
                .name(jobDTO.getName())
                .description(jobDTO.getDescription())
                .minimalSalary(jobDTO.getMinimalSalary())
                .internalCode(jobDTO.getInternalCode())
                .build();
    }

    public Job toJob(JobDTOWithoutEmployees jobDTOWithoutEmployees) {
        return Job.builder()
                .name(jobDTOWithoutEmployees.getName())
                .description(jobDTOWithoutEmployees.getDescription())
                .minimalSalary(jobDTOWithoutEmployees.getMinimalSalary())
                .internalCode(jobDTOWithoutEmployees.getInternalCode())
                .employees(Collections.emptyList())
                .build();
    }

    public JobDTOWithId toDTOWithId(Job job) {
        return JobDTOWithId.builder()
                .id(job.getId())
                .name(job.getName())
                .description(job.getDescription())
                .minSalary(job.getMinimalSalary())
                .employees(EmployeeMapperHelper.empDTOWithoutInternalCodesList(job.getEmployees()))
                .internalCode(job.getInternalCode())
                .build();
    }

    public List<JobDTO> toDTOList(List<Job> jobList) {
        return jobList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
