package com.learn.withravi.employee_service.controller;

import com.learn.withravi.employee_service.dto.APIResponseDto;
import com.learn.withravi.employee_service.dto.EmployeeDto;
import com.learn.withravi.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeId(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

}
