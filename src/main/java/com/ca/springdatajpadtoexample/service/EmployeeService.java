package com.ca.springdatajpadtoexample.service;

import com.ca.springdatajpadtoexample.entites.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee save(Employee employee);

    void update(Employee employee, Integer id);

    void delete(Integer id);

    Employee getFindById(Integer id);
}
