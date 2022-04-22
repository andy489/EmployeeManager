package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import com.fmi.employee.manager.model.Job;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobDTOMapper {
    public JobDTO toDTO(Job job) {
        return new JobDTO(
                job.getName(),
                job.getDescription(),
                job.getMinimalSalary()
        );
    }

    public JobDTOWithId toDTOWithId(Job job) {
        return new JobDTOWithId(
                job.getId(),
                job.getName(),
                job.getDescription(),
                job.getMinimalSalary()
        );
    }

    public List<JobDTO> toDTOList(List<Job> jobList) {
        return jobList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
