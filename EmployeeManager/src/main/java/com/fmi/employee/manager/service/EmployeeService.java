package com.fmi.employee.manager.service;

import com.fmi.employee.manager.dto.EmpDTO;
import com.fmi.employee.manager.dto.EmpDTOWithId;
import com.fmi.employee.manager.dto.EmpDTOWithJobAndOrg;

public interface EmployeeService {
    EmpDTOWithJobAndOrg saveEmployee(EmpDTO employeeDTO);
}
