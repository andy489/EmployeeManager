package com.fmi.employee.manager.mapper;

import com.fmi.employee.manager.dto.EmpDTO;
import com.fmi.employee.manager.dto.EmpDTOWithId;
import com.fmi.employee.manager.dto.EmpDTOWithJobAndOrg;
import com.fmi.employee.manager.dto.OrgDTOWithoutEmployees;
import com.fmi.employee.manager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTOMapper {

    private final JobDTOMapper jobMapper;
    private final OrgDTOMapper orgMapper;

    @Autowired
    public EmployeeDTOMapper(JobDTOMapper jobMapper, OrgDTOMapper orgMapper) {
        this.jobMapper = jobMapper;
        this.orgMapper = orgMapper;
    }

    public EmpDTO toDTO(Employee employee) {
        return new EmpDTO(
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

    public EmpDTOWithId toDTOWithId(Employee employee) {
        return new EmpDTOWithId(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getTopSkill(),
                jobMapper.toDTO(employee.getJob()),
                orgMapper.toDTO(employee.getOrg())
        );
    }

    public EmpDTOWithJobAndOrg toDTOWithJobAndOrg(Employee employee) {
        return new EmpDTOWithJobAndOrg(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getTopSkill(),

                jobMapper.toJobDTOWithoutEmployees(employee.getJob()),
                orgMapper.toOrgDTOWothoutEmployees(employee.getOrg())
        );
    }
}
