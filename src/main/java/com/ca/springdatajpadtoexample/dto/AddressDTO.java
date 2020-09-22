package com.ca.springdatajpadtoexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private int employeeId;
    private String doorNumber;
    private String street;
    private String city;
}
