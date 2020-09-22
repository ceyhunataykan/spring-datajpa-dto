package com.ca.springdatajpadtoexample.repository;


import com.ca.springdatajpadtoexample.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
