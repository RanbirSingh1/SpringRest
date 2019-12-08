package com.howtodoinjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.rest.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
