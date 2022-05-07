package com.fmi.employee.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmi.employee.manager.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private String name;
    private String description;

    @Min(750)
    @Positive
    private Integer minimalSalary;

    @JsonIgnoreProperties(value = {"job", "org"})
    private List<EmpDTOWithoutInternalCodes> employees;

    @Pattern(regexp = "^[A-Z]{1,8}$", message = "Internal codes must consist max 8 uppercase characters")
    private String internalCode;
}
