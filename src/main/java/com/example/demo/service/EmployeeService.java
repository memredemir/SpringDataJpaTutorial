package com.example.demo.service;

import com.example.demo.domain.Employee;

import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee findById(int employeeId);
    Iterable<Employee> findAll(Optional<String> emailAddress);
    void deleteEmployee(int employeeId);
}
