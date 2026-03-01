package com.learn.withravi.departmentservice.service;

import com.learn.withravi.departmentservice.dto.DepartmentDto;
import com.learn.withravi.departmentservice.entity.Department;
import com.learn.withravi.departmentservice.exception.ResourceNotFoundException;
import com.learn.withravi.departmentservice.mapper.AutoDepartmentMapper;
import com.learn.withravi.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;


    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // Convert DepartmentDto to Department entity
       Department department = AutoDepartmentMapper.MAPPER.maptoDepartment(departmentDto);

       Department savedDepartment = departmentRepository.save(department);

       //convert saved Department entity back to DepartmentDto
         DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.maptoDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }
    
    public DepartmentDto findByDepartmentCode(String departmentCode) {
        Department department =departmentRepository.findByDepartmentCode(departmentCode);
        if(department == null){
            throw new ResourceNotFoundException("Department", "departmentCode", departmentCode);
        }
        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.maptoDepartmentDto(department);
        return departmentDto;
    }
}
