package com.learn.withravi.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
    description = "APIResponseDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    @Schema(
        description = "Employee Information"
    )
    private EmployeeDto employee;
    @Schema(
        description = "Department Information"
    )
    private DepartmentDto department;
    @Schema(
        description = "Organization Information"
    )
    private OrganizationDto organization;
}