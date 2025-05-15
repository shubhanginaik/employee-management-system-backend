package com.example.full_stack_project.controller;

import com.example.full_stack_project.model.Employee;
import com.example.full_stack_project.service.EmployeeService;
import com.example.full_stack_project.service.EmployeeServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping
  public List<Employee> getEmployee() {
    return employeeService.getEmployee();
  }

}
