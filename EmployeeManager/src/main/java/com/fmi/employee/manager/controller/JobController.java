package com.fmi.employee.manager.controller;

import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.dto.JobDTOWithId;
import com.fmi.employee.manager.model.Job;
import com.fmi.employee.manager.service.JobService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("job/template")
    public Job getJSONTemplate() {
        return new Job(
                0L,
                "test-name",
                "test-description",
                0,
                Collections.emptyList(),
                LocalDateTime.now()
        );
    }

    @PostMapping("job")
    public ResponseEntity<JobDTOWithId> saveJob(@RequestBody JobDTO jobDTO) {
        return new ResponseEntity<>(jobService.saveJob(jobDTO), HttpStatus.CREATED);
    }

    @PostMapping("/jobs")
    public ResponseEntity<List<JobDTOWithId>> saveAll(@RequestBody List<JobDTO> jobDTO) {
        return new ResponseEntity<>(jobService.saveAll(jobDTO), HttpStatus.CREATED);
    }


}
