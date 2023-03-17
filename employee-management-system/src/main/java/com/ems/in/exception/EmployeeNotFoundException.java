package com.ems.in.exception;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(){

    }
    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
