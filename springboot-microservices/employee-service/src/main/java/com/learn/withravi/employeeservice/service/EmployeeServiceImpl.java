package com.learn.withravi.employeeservice.service;

import com.learn.withravi.employeeservice.dto.EmployeeDto;
import com.learn.withravi.employeeservice.entity.Employee;
import com.learn.withravi.employeeservice.mapper.AutoEmployeeMapper;
import com.learn.withravi.employeeservice.repository.EmployeeRespository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRespository employeeRespository;

    public EmployeeServiceImpl(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRespository.save(employee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeId(Long id) {
        Employee employee = employeeRespository.findById(id).get();
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(employee);
            return employeeDto;
    }
}
