package com.ca.springdatajpadtoexample.service;

import com.ca.springdatajpadtoexample.entites.Employee;
import com.ca.springdatajpadtoexample.exception.GenericNotFoundException;
import com.ca.springdatajpadtoexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employeeBody) {
        return employeeRepository.save(employeeBody);
    }

    @Override
    public void update(Employee employee, Integer id) {
        Employee optionalEmployee = getFindById(id);
        if (!(optionalEmployee == null)) {
            employee.setEmployeeId(id);
            employeeRepository.save(employee);
        } else {
            throw new GenericNotFoundException();
        }
    }

    @Override
    public void delete(Integer id) {
        Employee optionalEmployee = getFindById(id);
        if (!(optionalEmployee == null)) {
            employeeRepository.deleteById(id);
        } else {
            throw new GenericNotFoundException();
        }
    }

    @Override
    public Employee getFindById(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            throw new GenericNotFoundException();
        }
        return optionalEmployee.get();
    }

}
