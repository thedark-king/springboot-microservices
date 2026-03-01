package com.learn.withravi.employee_service.service.impl;

import com.learn.withravi.employee_service.dto.APIResponseDto;
import com.learn.withravi.employee_service.dto.DepartmentDto;
import com.learn.withravi.employee_service.dto.EmployeeDto;
import com.learn.withravi.employee_service.entity.Employee;
import com.learn.withravi.employee_service.exception.ResourceNotFoundException;
import com.learn.withravi.employee_service.mapper.AutoEmployeeMapper;
import com.learn.withravi.employee_service.repository.EmployeeRespository;
import com.learn.withravi.employee_service.service.APIClient;
import com.learn.withravi.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRespository employeeRespository;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
      private APIClient apiClient;
//    public EmployeeServiceImpl(EmployeeRespository employeeRespository, RestTemplate restTemplate, WebClient webClient) {
//        this.employeeRespository = employeeRespository;
////        this.restTemplate = restTemplate;
//        this.webClient = webClient;
//    }
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRespository.save(employee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeId(Long id) {
        Employee employee = employeeRespository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate
//                .getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
//        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(employee);
        DepartmentDto departmentDto = apiClient.getDepartmentById(employeeDto.getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
