package com.fmi.employee.manager.service.impl;

import com.fmi.employee.manager.dto.EmpDTO;
import com.fmi.employee.manager.dto.EmpDTOWithId;
import com.fmi.employee.manager.mapper.EmployeeDTOMapper;
import com.fmi.employee.manager.model.Employee;
import com.fmi.employee.manager.model.Job;
import com.fmi.employee.manager.model.Organization;
import com.fmi.employee.manager.repository.EmployeeRepository;
import com.fmi.employee.manager.service.EmployeeService;
import com.fmi.employee.manager.service.JobService;
import com.fmi.employee.manager.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;

    private final JobService jobService;
    private final OrganizationService orgService;

    private final EmployeeDTOMapper mapper;

    @Autowired
    public EmployeeServiceImpl(
            EmployeeRepository employeeRepo,
            JobService jobService,
            OrganizationService orgService,
            EmployeeDTOMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.jobService = jobService;
        this.orgService = orgService;
        this.mapper = mapper;
    }

    @Override
    public EmpDTOWithId saveEmployee(EmpDTO employeeDTO) {
        Job jobToAttach = jobService.getJobByInternalCode(employeeDTO.getJobCode());
        Organization orgToAttach = orgService.getOrgByInternalCode(employeeDTO.getOrgCode());

        Employee employeeToReturn = Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .phone(employeeDTO.getPhone())
                .hireDate(employeeDTO.getHireDate())
                .salary(employeeDTO.getSalary())
                .topSkill(employeeDTO.getTopSkill())
                .job(jobToAttach)
                .org(orgToAttach)
                .build();

        employeeRepo.save(employeeToReturn);

        return mapper.toDTOWithId(employeeToReturn);
    }
}
