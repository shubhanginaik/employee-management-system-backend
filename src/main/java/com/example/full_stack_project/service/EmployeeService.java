package com.example.full_stack_project.service;


import com.example.full_stack_project.entity.EmployeeEntity;
import com.example.full_stack_project.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

  Employee createEmployee(Employee employee);

  List<Employee> getEmployee();

  boolean deleteEmployee(Long empId);

  Optional<Employee> getEmployeeById(Long id);
  Employee updateEmployee(Long id, Employee employee);
}
