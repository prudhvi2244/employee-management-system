package com.ems.in.repository;

import com.ems.in.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

  List<Employee> findByEmployeeCity(String employeeCity);

  @Query(value = "select e from Employee e where e.employeeName=?1")
  List<Employee> getEmployeesByName(String employeeName);


  @Query(value = "select * from employee  where employee_email=?1",nativeQuery = true)
  Employee getEmployeeByEmail(String employeeEmail);

}
