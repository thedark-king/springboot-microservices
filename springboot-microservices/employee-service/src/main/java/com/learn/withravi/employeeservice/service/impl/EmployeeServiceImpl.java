package com.learn.withravi.employeeservice.service.impl;

import com.learn.withravi.employeeservice.dto.APIResponseDto;
import com.learn.withravi.employeeservice.dto.DepartmentDto;
import com.learn.withravi.employeeservice.dto.EmployeeDto;
import com.learn.withravi.employeeservice.entity.Employee;
import com.learn.withravi.employeeservice.mapper.AutoEmployeeMapper;
import com.learn.withravi.employeeservice.repository.EmployeeRespository;
import com.learn.withravi.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    // private RestTemplate restTemplate;
    private WebClient webClient;
//    private APIClient apiClient;
    private final EmployeeRespository employeeRespository;

    public EmployeeServiceImpl(EmployeeRespository employeeRespository,
                               WebClient.Builder builder) {
        this.employeeRespository = employeeRespository;
        this.webClient = builder.build();
    }
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRespository.save(employee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeId(Long id) {
        Employee employee = employeeRespository.findById(id).get();
        DepartmentDto departmentDto = webClient.get()
                .uri("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
//        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(employee);

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {
        Employee employee = employeeRespository.findById(id).get();
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Reseach and Development Department");


        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
