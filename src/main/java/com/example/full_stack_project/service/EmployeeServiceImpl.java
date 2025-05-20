package com.example.full_stack_project.service;

import com.example.full_stack_project.entity.EmployeeEntity;
import com.example.full_stack_project.model.Employee;
import com.example.full_stack_project.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee createEmployee(Employee employee) {
    EmployeeEntity employeeEntity=  new EmployeeEntity();
    BeanUtils.copyProperties(employee,employeeEntity);
    EmployeeEntity savedEntity= employeeRepository.save(employeeEntity);
    Employee savedEmployee = new Employee();
    BeanUtils.copyProperties(savedEntity, savedEmployee);
    return savedEmployee;
  }

  @Override
  public List<Employee> getEmployee() {
    List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

     return employeeEntities
        .stream()
        .map(emp ->
            new Employee(emp.getEmpId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail()))
         .toList();
  }

  @Override
  public boolean deleteEmployee(Long empId) {
    EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
    if (employeeEntity != null) {
      employeeRepository.delete(employeeEntity);
      return true;
    }
    return false;
  }
}
