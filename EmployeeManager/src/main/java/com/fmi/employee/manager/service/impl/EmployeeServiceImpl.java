package com.fmi.employee.manager.service.impl;

import com.fmi.employee.manager.dto.EmployeeDTO;
import com.fmi.employee.manager.dto.EmployeeDTOWithID;
import com.fmi.employee.manager.mapper.EmployeeDTOMapper;
import com.fmi.employee.manager.model.Employee;
import com.fmi.employee.manager.repository.EmployeeRepository;
import com.fmi.employee.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeDTOMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeDTOMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

//    @Override
//    public EmployeeDTOWithID saveEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = new Employee();
//
//        employee.update(employeeDTO); // Missing JOB and ORG
//
//
//    }
}
