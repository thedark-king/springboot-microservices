package com.learn.withravi.employeeservice.service.impl;

import com.learn.withravi.employeeservice.dto.APIResponseDto;
import com.learn.withravi.employeeservice.dto.DepartmentDto;
import com.learn.withravi.employeeservice.dto.EmployeeDto;
import com.learn.withravi.employeeservice.dto.OrganizationDto;
import com.learn.withravi.employeeservice.entity.Employee;
import com.learn.withravi.employeeservice.mapper.EmployeeMapper;
import com.learn.withravi.employeeservice.repository.EmployeeRespository;
import com.learn.withravi.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    // private RestTemplate restTemplate;
    // private APIClient apiClient;
    private WebClient webClient;
    private final EmployeeRespository employeeRespository;
    private Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRespository employeeRespository, WebClient.Builder builder) {
        this.employeeRespository = employeeRespository;
        this.webClient = builder.build();
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = AutoEmployeeMapper.MAPPER.maptoEmployee(employeeDto);
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRespository.save(employee);

//        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    //    @CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeId(Long id) {
        LOGGER.info("Inside getEmployeeId method of EmployeeServiceImpl");

        Employee employee = employeeRespository.findById(id).get();

        DepartmentDto departmentDto = webClient.get().uri("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
//        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(employee);

        OrganizationDto organizationDto = webClient.get()
                .uri("http://ORGANIZATION-SERVICE/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {

        LOGGER.info("Inside getDefaultDepartment method of EmployeeServiceImpl");

        Employee employee = employeeRespository.findById(id).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Reseach and Development Department");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
