package com.ca.springdatajpadtoexample.controller;

import com.ca.springdatajpadtoexample.dto.AddressDTO;
import com.ca.springdatajpadtoexample.dto.AddressDTOService;
import com.ca.springdatajpadtoexample.dto.EmployeeDTO;
import com.ca.springdatajpadtoexample.dto.EmployeeDTOService;
import com.ca.springdatajpadtoexample.entites.Employee;
import com.ca.springdatajpadtoexample.exception.GenericNotFoundException;
import com.ca.springdatajpadtoexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDTOService employeeDTOService;
    @Autowired
    private AddressDTOService addressDTOService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/employee/find-by-id/{id}")
    public ResponseEntity<Employee> getFindById(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.getFindById(id), HttpStatus.OK);
    }

    @GetMapping("/dto/address_list")
    public ResponseEntity<List<AddressDTO>> getAddressAll() {
        return new ResponseEntity<>(addressDTOService.getAddressDTO(), HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<Object> update(@RequestBody Employee employee, @PathVariable Integer id) {
        employeeService.update(employee, id);
        return new ResponseEntity<>("true", HttpStatus.OK);
    }

    @PutMapping("/dto/update/{id}")
    public ResponseEntity<Employee> updateDTO(@RequestBody EmployeeDTO empDTO, @PathVariable Integer id){
        return new ResponseEntity<>(employeeDTOService.update_tc(empDTO,id), HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) throws GenericNotFoundException {
        employeeService.delete(id);
        return new ResponseEntity<>("true", HttpStatus.OK);
    }
}
