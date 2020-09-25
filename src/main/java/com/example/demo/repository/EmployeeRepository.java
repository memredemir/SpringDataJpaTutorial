package com.example.demo.repository;

import com.example.demo.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
        @Query("select e from Employee e where e.emailAddress = ?1")
        List<Employee> findByEmailAddress(String emailAddress);
        //List<Employee> findByEmailAddress(String emailAddress);
        List<Employee> findByFirstName(String firstName);
}
