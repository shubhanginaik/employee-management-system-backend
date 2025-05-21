package com.example.full_stack_project.service;

import com.example.full_stack_project.entity.EmployeeEntity;
import com.example.full_stack_project.model.Employee;
import com.example.full_stack_project.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
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

  @Override
  public Optional<Employee> getEmployeeById(Long id) {
    Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
    if (employeeEntity.isPresent()) {
      Employee employee = new Employee();
      BeanUtils.copyProperties(employeeEntity.get(), employee);
      return Optional.of(employee);
    } else {
      return Optional.empty();
    }
  }

  @Override
  public Employee updateEmployee(Long id, Employee employee) {
    Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
    if(employeeEntityOptional.isPresent()){
      EmployeeEntity employeeEntity = employeeEntityOptional.get();
      if(employee.getFirstName() != null) {
        employeeEntity.setFirstName(employee.getFirstName());
      }
      if(employee.getLastName() != null) {
        employeeEntity.setLastName(employee.getLastName());
      }
      if(employee.getEmail() != null) {
        employeeEntity.setEmail(employee.getEmail());
      }
      EmployeeEntity updatedEmployeeEntity = employeeRepository.save(employeeEntity);
      Employee updatedEmployee = new Employee();
      BeanUtils.copyProperties(updatedEmployeeEntity, updatedEmployee);
      return updatedEmployee;
    }
    return null;
  }
}
