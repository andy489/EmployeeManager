package com.fmi.employee.manager.controller;

import com.fmi.employee.manager.dto.EmpDTO;
import com.fmi.employee.manager.dto.EmpDTOWithId;
import com.fmi.employee.manager.mapper.EmployeeDTOMapper;
import com.fmi.employee.manager.model.Employee;
import com.fmi.employee.manager.model.Job;
import com.fmi.employee.manager.model.Organization;
import com.fmi.employee.manager.service.EmployeeService;
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

@RestController
@RequestMapping("api")
public class EmployeeController {
    private EmployeeService empService;
    private EmployeeDTOMapper mapper;

    @Autowired
    public EmployeeController(EmployeeService empService, EmployeeDTOMapper mapper) {
        this.empService = empService;
        this.mapper = mapper;
    }

    // http://localhost:8080/api/emp/template
    @GetMapping("emp/template")
    public Employee getJSONTemplate() {
        return new Employee(
                0L,
                "test-first-name",
                "test-last-name",
                "test-email",
                "test-phone",
                LocalDateTime.now(),
                0d,
                "test-top-skill",
                LocalDateTime.now(),
                new Job(
                        0L,
                        "test-name",
                        "test-description",
                        0,
                        "test-internal-code",
                        Collections.emptyList(),
                        LocalDateTime.now()
                ),
                new Organization(
                        0L,
                        "test-name",
                        "test-web-site",
                        "test-internal-code",
                        Collections.emptyList(),
                        LocalDateTime.now()
                )
        );
    }

    // CAUSES STACKOVERFLOW EXCEPTION!

    // http://localhost:8080/api/emp
    @PostMapping("emp")
    public ResponseEntity<EmpDTOWithId> saveSingleJob(@RequestBody EmpDTO empDTO) {
        return new ResponseEntity<>(empService.saveEmployee(empDTO), HttpStatus.CREATED);
    }
}
