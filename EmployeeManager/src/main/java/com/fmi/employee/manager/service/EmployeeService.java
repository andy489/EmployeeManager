package com.fmi.employee.manager.service;

import com.fmi.employee.manager.dto.EmpDTO;
import com.fmi.employee.manager.dto.EmpDTOWithId;

public interface EmployeeService {
    EmpDTOWithId saveEmployee(EmpDTO employeeDTO);
}
