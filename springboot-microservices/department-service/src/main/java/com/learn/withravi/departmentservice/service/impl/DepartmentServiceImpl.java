package com.learn.withravi.departmentservice.service.impl;

import com.learn.withravi.departmentservice.dto.DepartmentDto;
import com.learn.withravi.departmentservice.entity.Department;
import com.learn.withravi.departmentservice.mapper.DepartmentMapper;
import com.learn.withravi.departmentservice.repository.DepartmentRepository;
import com.learn.withravi.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;


    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // Convert DepartmentDto to Department entity
       Department  department = department = DepartmentMapper.mapToDepartment(departmentDto);

       Department savedDepartment = departmentRepository.save(department);

       //convert saved Department entity back to DepartmentDto
         DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDTO(savedDepartment);

        return savedDepartmentDto;
    }
    
    public DepartmentDto findByDepartmentCode(String departmentCode) {
        Department department =departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto =  DepartmentMapper.mapToDepartmentDTO(department);

        return departmentDto;
    }
}
