package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        employeeRepository = repository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(0);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Iterable<Employee> findAll(Optional<String> emailAddress) {
        if(emailAddress.isPresent()){
            return employeeRepository.findByEmailAddress(emailAddress.get());
        }
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.orElse(null);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
