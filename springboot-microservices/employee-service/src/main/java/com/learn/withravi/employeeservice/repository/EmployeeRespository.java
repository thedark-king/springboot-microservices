package com.learn.withravi.employeeservice.repository;

import com.learn.withravi.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}
