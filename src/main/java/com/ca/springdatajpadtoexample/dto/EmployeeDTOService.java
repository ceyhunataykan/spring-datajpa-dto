package com.ca.springdatajpadtoexample.dto;

import com.ca.springdatajpadtoexample.entites.Employee;

public interface EmployeeDTOService {
    Employee update_tc(EmployeeDTO employeeDTO, Integer id);
}
