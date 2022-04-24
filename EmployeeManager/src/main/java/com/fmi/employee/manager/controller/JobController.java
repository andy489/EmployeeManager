package com.fmi.employee.manager.controller;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // http://localhost:8080/api/job/template
    @GetMapping("job/template")
    public Job getJSONTemplate() {
        return new Job(
                0L,
                "test-name",
                "test-description",
                0,
                Collections.emptyList(),
                "test-internal-code",
                LocalDateTime.now()
        );
    }

    // http://localhost:8080/api/job
    @PostMapping("job")
    public ResponseEntity<JobDTOWithId> saveSingleJob(@RequestBody JobDTO jobDTO) {
        return new ResponseEntity<>(jobService.saveJob(jobDTO), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/jobs
    @PostMapping("jobs")
    public ResponseEntity<List<JobDTOWithId>> saveMultipleJobs(@RequestBody List<JobDTO> jobDTO) {
        return new ResponseEntity<>(jobService.saveAll(jobDTO), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/job
    @GetMapping("job")
    public ResponseEntity<List<JobDTO>> listJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    // http://localhost:8080/api/job/7
    @GetMapping("job/id/{id}")
    public ResponseEntity<JobDTOWithId> getJobById(@PathVariable("id") Long jobId) {
        return new ResponseEntity<>(jobService.getJobById(jobId), HttpStatus.OK);
    }

    // http://localhost:8080/api/job/keywords?word=data,end
    // http://localhost:8080/api/job/keywords?word=data&word=end
    @GetMapping("job/keywords")
    public ResponseEntity<List<JobDTO>> getJobsWithKeywords(
            @RequestParam(required = false, value = "word") String[] keyWords
    ) {
        if (keyWords == null) {
            return listJobs();
        }

        return new ResponseEntity<>(jobService.getJobsWithKeywords(keyWords), HttpStatus.OK);
    }

    // http://localhost:8080/api/job/a
    @GetMapping("job/a")
    public ResponseEntity<String> getAverageMinJobSalary() {
        final DecimalFormat df = new DecimalFormat("0.00");

        return new ResponseEntity<>(df.format(jobService.getAverageMinJobSalary()), HttpStatus.OK);
    }

    // http://localhost:8080/api/job/s/3000
    @GetMapping("/job/s/{salary}")
    public ResponseEntity<List<JobDTO>> getJobWitMinSalaryAtLeast(@PathVariable("salary") Integer minSalary) {
        return new ResponseEntity<>(jobService.getJobsWithMinSalaryAtLeast(minSalary), HttpStatus.OK);
    }

    // http://localhost:8080/api/job/7
    @PatchMapping("job/{id}")
    public ResponseEntity<JobDTOWithId> partialUpdateJob(
            @PathVariable("id") Long jobId,
            @RequestBody Map<Object, Object> fields
    ) {
        return new ResponseEntity<>(jobService.partialUpdateJob(jobId, fields), HttpStatus.OK);
    }

    // http://localhost:8080/api/job
    @PutMapping("job")
    public ResponseEntity<JobDTOWithId> updateJob(@RequestBody JobDTOWithId jobDTOWithId) {
        return new ResponseEntity<>(jobService.updateJob(jobDTOWithId), HttpStatus.OK);
    }

    // http://localhost:8080/api/job/7
    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long jobId) {
        jobService.deleteJob(jobId);
        return new ResponseEntity<>(String.format("~Job with id %d was deleted successfully.", jobId), HttpStatus.OK);
    }
}
