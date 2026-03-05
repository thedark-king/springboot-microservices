package com.learn.withravi.departmentservice.controller;

import com.learn.withravi.departmentservice.dto.DepartmentDto;
import com.learn.withravi.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Department Controller", 
    description = "APIs for managing departments")
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

        public DepartmentController(DepartmentService departmentService) {
            this.departmentService = departmentService;
        }

        @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to save department into database"
        )
        @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
        )
        @PostMapping
        public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
                DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
                return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
        }
        @Operation(
            summary = "Get Department REST API",
            description = "Get Department REST API is used to get department from database"
        )   
        @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
        )
        @GetMapping("/{department-code}")
        public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("department-code") String departmentCode){
            DepartmentDto departmentDto = departmentService.findByDepartmentCode(departmentCode);
            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
        }


}
