package com.learn.withravi.employee_service.service;

import com.learn.withravi.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeId(Long id);
}
