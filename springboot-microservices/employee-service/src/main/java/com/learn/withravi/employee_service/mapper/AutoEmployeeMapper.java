package com.learn.withravi.employee_service.mapper;

import com.learn.withravi.employee_service.dto.EmployeeDto;
import com.learn.withravi.employee_service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);
     EmployeeDto maptoEmployeeDto(Employee employee);
     Employee maptoEmployee(EmployeeDto employeeDto);
}
