package com.example.full_stack_project.controller;

import com.example.full_stack_project.model.Employee;
import com.example.full_stack_project.service.EmployeeService;
import com.example.full_stack_project.service.EmployeeServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
    boolean deleted = false;
    deleted = employeeService.deleteEmployee(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", deleted);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id){
    Optional<Employee> employee = employeeService.getEmployeeById(id);
    if (employee.isPresent()) {
      return ResponseEntity.ok(employee);
    } else {
      return ResponseEntity.notFound().build();
    }

  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    Employee updatedEmployee = employeeService.updateEmployee(id, employee);
    if (updatedEmployee != null) {
      return ResponseEntity.ok(updatedEmployee);
    } else {
      return ResponseEntity.notFound().build();
    }
  }


}
