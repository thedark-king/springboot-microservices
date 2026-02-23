package com.learn.withravi.departmentservice.service;

import com.learn.withravi.departmentservice.dto.DepartmentDto;
import com.learn.withravi.departmentservice.entity.Department;
import com.learn.withravi.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;


    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // Convert DepartmentDto to Department entity
       Department  department = department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

       Department savedDepartment = departmentRepository.save(department);

       //convert saved Department entity back to DepartmentDto
         DepartmentDto savedDepartmentDto = new DepartmentDto(
                 savedDepartment.getId(),
                 savedDepartment.getDepartmentName(),
                    savedDepartment.getDepartmentDescription(),
                    savedDepartment.getDepartmentCode()
         );
        return savedDepartmentDto;
    }
    
    public DepartmentDto findByDepartmentCode(String departmentCode) {
        Department department =departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
