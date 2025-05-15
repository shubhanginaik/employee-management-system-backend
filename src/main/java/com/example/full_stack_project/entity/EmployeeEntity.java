package com.example.full_stack_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long empId;
  private String firstName;
  private String lastName;
  private String email;

}
