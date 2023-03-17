package com.ems.in.service;

import com.ems.in.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Integer employeeId);
    List<Employee> getAllEmployees();
    void deleteEmployee(Integer employeeID);
    List<Employee> getAllEmployeesByCity(String city);
    List<Employee> getAllEmployeesByName(String employeeName);
    Employee getEmployeeByEmail(String employeeEmail);
}
