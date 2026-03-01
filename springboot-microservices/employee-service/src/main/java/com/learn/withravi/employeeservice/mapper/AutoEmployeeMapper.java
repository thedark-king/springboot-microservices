package com.learn.withravi.employeeservice.mapper;

import com.learn.withravi.employeeservice.dto.EmployeeDto;
import com.learn.withravi.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);
     EmployeeDto maptoEmployeeDto(Employee employee);
     Employee maptoEmployee(EmployeeDto employeeDto);
}
