package com.fmi.employee.manager.service.impl;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import com.fmi.employee.manager.exception.ResourceNotFoundException;
import com.fmi.employee.manager.mapper.JobDTOMapper;
import com.fmi.employee.manager.model.Job;
import com.fmi.employee.manager.repository.JobRepository;
import com.fmi.employee.manager.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        Optional<Job> existingJob = jobRepo.findById(id);

        if (existingJob.isPresent()) {
            return mapper.toDTOWithId(existingJob.get());
        }

        throw new ResourceNotFoundException("Job", "Id", id);
    }

    @Override
    public List<JobDTO> getJobsWithKeywords(String... keywords) {
        List<String> keywordsList = Arrays.stream(keywords)
                .map(String::toLowerCase).collect(Collectors.toList());

        final Pattern WORD_SPLIT_PATTERN = Pattern.compile("[^a-zA-Z0-9]+");

        return jobRepo.findAll().stream()
                .map(mapper::toDTO)
                .filter(
                        job -> WORD_SPLIT_PATTERN.splitAsStream(job.getDescription())
                                .map(String::toLowerCase)
                                .collect(Collectors.toList())
                                .containsAll(keywordsList)
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<JobDTO> getJobsWithMinSalaryAtLeast(Integer minSalary) {
        return jobRepo.findAll().stream()
                .map(mapper::toDTO)
                .filter(job -> job.getMinimalSalary() > minSalary)
                .collect(Collectors.toList());
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
