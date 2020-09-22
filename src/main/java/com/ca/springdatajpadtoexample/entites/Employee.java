package com.ca.springdatajpadtoexample.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(length = 100)
    private String employeeName;

    @Column(length = 11)
    private String employeeTC;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Address address;
}
