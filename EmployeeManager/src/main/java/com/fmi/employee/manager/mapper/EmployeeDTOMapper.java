package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.EmployeeDTO;
import com.fmi.employee.manager.dto.EmployeeDTOWithID;
import com.fmi.employee.manager.dto.JobDTO;
import com.fmi.employee.manager.model.Employee;

public class EmployeeDTOMapper {
    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getTopSkill(),
                employee.getJob().getInternalCode(),
                employee.getOrg().getInternalCode()
        );
    }

    public EmployeeDTOWithID toDTOWithId(Employee employee) {
        return new EmployeeDTOWithID(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getTopSkill(),
                employee.getJob().getInternalCode(),
                employee.getOrg().getInternalCode()
        );
    }
}
