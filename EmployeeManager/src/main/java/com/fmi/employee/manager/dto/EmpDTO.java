package com.fmi.employee.manager.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {

    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^\\+\\d{10,12}$", message = "Phone number must start with + and have 10 to 12 digits")
    private String phone;

    private LocalDateTime hireDate;

    @Min(750)
    @Positive
    private Double salary;

    private String topSkill;

    @NotNull
    private String jobCode;
    @NotNull
    private String orgCode;
}
