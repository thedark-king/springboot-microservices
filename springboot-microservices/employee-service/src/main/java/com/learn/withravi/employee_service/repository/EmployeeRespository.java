package com.learn.withravi.employee_service.repository;

import com.learn.withravi.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}
