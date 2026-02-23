package com.learn.withravi.departmentservice.service;

import com.learn.withravi.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto findByDepartmentCode(String id);
}
