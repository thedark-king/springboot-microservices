package com.learn.withravi.employeeservice.controller;

import com.learn.withravi.employeeservice.dto.APIResponseDto;
import com.learn.withravi.employeeservice.dto.EmployeeDto;
import com.learn.withravi.employeeservice.service.EmployeeService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Employee Controller", 
    description = "APIs for managing employees"
)
@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

      @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee REST API is used to save employee into database"
        )
        @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
        )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to get employee from database"
        )
        @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
        )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeId(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

}
