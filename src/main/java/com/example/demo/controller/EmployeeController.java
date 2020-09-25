package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService service) {
        employeeService = service;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAll(@RequestParam Optional<String> emailAddress){
        return new ResponseEntity<>(employeeService.findAll(emailAddress), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if(employee != null)
            return new ResponseEntity<>(employee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
