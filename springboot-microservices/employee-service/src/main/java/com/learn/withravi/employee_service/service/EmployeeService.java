package com.learn.withravi.employee_service.service;

import com.learn.withravi.employee_service.dto.APIResponseDto;
import com.learn.withravi.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeId(Long id);
}
