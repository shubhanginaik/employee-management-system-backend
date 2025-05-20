package com.example.full_stack_project.service;


import com.example.full_stack_project.model.Employee;
import java.util.List;

public interface EmployeeService {

  Employee createEmployee(Employee employee);

  List<Employee> getEmployee();

  boolean deleteEmployee(Long empId);
}
