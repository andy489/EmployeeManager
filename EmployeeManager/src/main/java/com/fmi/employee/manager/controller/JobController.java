package com.fmi.employee.manager.controller;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import com.fmi.employee.manager.dto.JobDTOWithoutEmployees;
import com.fmi.employee.manager.mapper.JobDTOMapper;
import com.fmi.employee.manager.model.Job;
import com.fmi.employee.manager.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class JobController {

    private final JobService jobService;
    private final JobDTOMapper mapper;

    @Autowired
    public JobController(JobService jobService, JobDTOMapper mapper) {
        this.jobService = jobService;
        this.mapper = mapper;
    }

    @GetMapping("job/template")
    public Job getJSONTemplate() {
        return new Job(
                0L,
                "test-name",
                "test-description",
                0,
                "test-internal-code",
                Collections.emptyList(),
                LocalDateTime.now()
        );
    }

    @PostMapping("job")
    public ResponseEntity<JobDTOWithId> saveSingleJob(@RequestBody JobDTOWithoutEmployees jobDTOWithoutEmployees) {
        return new ResponseEntity<>(jobService.saveJob(jobDTOWithoutEmployees), HttpStatus.CREATED);
    }

    @PostMapping("jobs")
    public ResponseEntity<List<JobDTOWithId>> saveMultipleJobs(
            @RequestBody List<JobDTOWithoutEmployees> jobDTOWithoutEmployees
    ) {
        return new ResponseEntity<>(jobService.saveAll(jobDTOWithoutEmployees), HttpStatus.CREATED);
    }

    @GetMapping("job")
    public ResponseEntity<List<JobDTO>> listJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("job/id/{id}")
    public ResponseEntity<JobDTOWithId> getJobById(@PathVariable("id") Long jobId) {
        return new ResponseEntity<>(jobService.getJobById(jobId), HttpStatus.OK);
    }

    @GetMapping("job/code/{code}")
    public ResponseEntity<JobDTO> getJobByInternalCode(@PathVariable("code") String jobInternalCode) {
        return new ResponseEntity<>(mapper.toDTO(jobService.getJobByInternalCode(jobInternalCode)), HttpStatus.OK);
    }

    @GetMapping("job/keywords")
    public ResponseEntity<List<JobDTO>> getJobsWithKeywords(
            @RequestParam(required = false, value = "words") String[] keyWords
    ) {
        if (keyWords == null) {
            return listJobs();
        }

        return new ResponseEntity<>(jobService.getJobsWithKeywords(keyWords), HttpStatus.OK);
    }

    @GetMapping("job/a")
    public ResponseEntity<String> getAverageMinJobSalary() {
        final DecimalFormat df = new DecimalFormat("0.00");

        return new ResponseEntity<>(df.format(jobService.getAverageMinJobSalary()), HttpStatus.OK);
    }

    @GetMapping("/job/s/{salary}")
    public ResponseEntity<List<JobDTO>> getJobWitMinSalaryAtLeast(@PathVariable("salary") Integer minSalary) {
        return new ResponseEntity<>(jobService.getJobsWithMinSalaryAtLeast(minSalary), HttpStatus.OK);
    }

    @PatchMapping("job/{id}")
    public ResponseEntity<JobDTOWithId> partialUpdateJob(
            @PathVariable("id") Long jobId,
            @RequestBody Map<Object, Object> fields
    ) {
        return new ResponseEntity<>(jobService.partialUpdateJob(jobId, fields), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long jobId) {
        JobDTO deletedJob = jobService.deleteJob(jobId);
        return new ResponseEntity<>(
                String.format(
                        "~Job \"%s\" with id %d was deleted successfully.",
                        deletedJob.getName(), jobId
                ), HttpStatus.OK);
    }
}
