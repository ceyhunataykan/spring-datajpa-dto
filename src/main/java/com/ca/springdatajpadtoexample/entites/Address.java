package com.ca.springdatajpadtoexample.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @SequenceGenerator(initialValue = 1, name = "address_seq", sequenceName = "address_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @Column
    private int addressid;

    @Column
    private String doorNumber;

    @Column
    private String street;

    @Column
    private String city;
}
