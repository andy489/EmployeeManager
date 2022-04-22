package com.fmi.employee.manager.service.impl;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import com.fmi.employee.manager.mapper.JobDTOMapper;
import com.fmi.employee.manager.model.Job;
import com.fmi.employee.manager.repository.JobRepository;
import com.fmi.employee.manager.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepo;

    private final JobDTOMapper mapper;

    @Autowired
    public JobServiceImpl(JobRepository jobRepo, JobDTOMapper mapper) {
        this.jobRepo = jobRepo;
        this.mapper = mapper;
    }

    @Override
    public JobDTOWithId saveJob(JobDTO jobDTO) {
        Job job = new Job();
        job.update(jobDTO);

        return mapper.toDTOWithId(jobRepo.save(job));
    }

    @Override
    public List<JobDTOWithId> saveAll(List<JobDTO> jobDTO) {
        final int SIZE = jobDTO.size();

        List<Job> toAdd = jobDTO.stream().limit(SIZE).map(mapper::toJob).collect(Collectors.toList());

        return jobRepo.saveAll(toAdd).stream().map(mapper::toDTOWithId).collect(Collectors.toList());
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return mapper.toDTOList(jobRepo.findAll());
    }

    @Override
    public JobDTOWithId getJobById(Long id) {
        return null;
    }

    @Override
    public List<JobDTO> getJobsWithKeywords(String... keywords) {
        return null;
    }

    @Override
    public List<JobDTO> getJobsWithMinSalaryGreaterThan(Integer minSalary) {
        return null;
    }

    @Override
    public Double getAverageMinimalJobSalary() {
        return null;
    }

    @Override
    public JobDTOWithId updateJob(JobDTO jovDTO, Long id) {
        return null;
    }

    @Override
    public void deleteJob(Long id) {

    }
}
