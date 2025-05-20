package com.example.full_stack_project.controller;

import com.example.full_stack_project.model.Employee;
import com.example.full_stack_project.service.EmployeeService;
import com.example.full_stack_project.service.EmployeeServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employees")
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

  @DeleteMapping("/{empId}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long empId) {
    boolean deleted = false;
    deleted = employeeService.deleteEmployee(empId);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", deleted);
    return ResponseEntity.ok(response);
  }

}
