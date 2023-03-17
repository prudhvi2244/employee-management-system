package com.ems.in.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Integer employeeId;
    @Column
    private String employeeName;
    @Column
    private String employeeCity;
    @Column
    private Float employeeSalary;
    @Column(unique = true)
    private String employeeEmail;
}
