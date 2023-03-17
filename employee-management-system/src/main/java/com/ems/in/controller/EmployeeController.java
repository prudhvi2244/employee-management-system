package com.ems.in.controller;

import com.ems.in.entity.Employee;
import com.ems.in.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*
    {
        "employeeName":"Raj",
        "employeeSalary":150000.525,
        "employeeCity":"Hyderabad"
    }
     */
    // http://localhost:8080/employee/saveEmployee

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee savedEmployee=employeeService.saveEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    //http://localhost:8080/employee/12

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId){
        Employee emp=employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }


    //http://localhost:8080/employee/1

    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId){
        employeeService.deleteEmployee(employeeId);

        return new ResponseEntity<String>("Employee With ID "+employeeId+" Deleted Succesfully", HttpStatus.OK);
    }

    //http://localhost:8080/employee/allEmployees

    @GetMapping(value = "/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees=employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
    }


    @GetMapping(value = "/city/{cityName}")
    public ResponseEntity<List<Employee>> getAllEmployeesByCity(@PathVariable String cityName){
       return new ResponseEntity<List<Employee>>(employeeService.getAllEmployeesByCity(cityName),HttpStatus.OK);
    }

    @GetMapping(value = "/name/{employeeName}")
    public ResponseEntity<List<Employee>> getAllEmployeesByName(@PathVariable String employeeName){
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployeesByName(employeeName),HttpStatus.OK);
    }


    @GetMapping(value = "/email/{employeeEmail}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String employeeEmail){
        return new ResponseEntity<Employee>(employeeService.getEmployeeByEmail(employeeEmail),HttpStatus.OK);
    }
}
