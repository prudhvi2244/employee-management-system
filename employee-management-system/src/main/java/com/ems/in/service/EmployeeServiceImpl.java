package com.ems.in.service;

import com.ems.in.entity.Employee;
import com.ems.in.exception.EmployeeNotFoundException;
import com.ems.in.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
   private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
       Optional<Employee> optional=employeeRepository.findById(employeeId);
        return optional.orElseThrow(()->new EmployeeNotFoundException("Employee With ID :"+employeeId+" does not exist! "));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Integer employeeID) {
        Employee emp=getEmployeeById(employeeID);
        employeeRepository.deleteById(emp.getEmployeeId());
    }

    @Override
    public List<Employee> getAllEmployeesByCity(String city) {
        return employeeRepository.findByEmployeeCity(city);
    }

    @Override
    public List<Employee> getAllEmployeesByName(String employeeName) {
        return employeeRepository.getEmployeesByName(employeeName);
    }

    @Override
    public Employee getEmployeeByEmail(String employeeEmail) {
        return employeeRepository.getEmployeeByEmail(employeeEmail);
    }


}
