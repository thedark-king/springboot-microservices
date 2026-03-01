package com.learn.withravi.employeeservice.service;

import com.learn.withravi.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeId(Long id);
}
