package com.example.full_stack_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private long empId;
  private String firstName;
  private String lastName;
  private String email;

}
