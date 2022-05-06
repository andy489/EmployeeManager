package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.EmpDTOWithoutInternalCodes;
import com.fmi.employee.manager.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapperHelper {
    public static List<EmpDTOWithoutInternalCodes> empDTOWithoutInternalCodesList(List<Employee> employees) {
        return employees.stream()
                .map(e -> EmpDTOWithoutInternalCodes.builder()
                        .firstName(e.getFirstName())
                        .lastName(e.getLastName())
                        .email(e.getEmail())
                        .phone(e.getPhone())
                        .hireDate(e.getHireDate())
                        .salary(e.getSalary())
                        .topSkill(e.getTopSkill())
                        .build()
                ).collect(Collectors.toList());
    }
}
