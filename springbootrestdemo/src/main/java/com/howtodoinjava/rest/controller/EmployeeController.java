package com.howtodoinjava.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.RemoteProxyFailureException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.howtodoinjava.repository.EmployeeRepository;
import com.howtodoinjava.rest.dao.EmployeeDAO;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@RestController
@CrossOrigin
@RequestMapping(path = "/employees")
public class EmployeeController 
{
    /*@Autowired
    private EmployeeDAO employeeDao;
    */
    @Autowired
    EmployeeRepository empRepo;
    
    @GetMapping(path="/", produces = "application/json")
    public List<Employee> getEmployees() 
    {
        return empRepo.findAll();
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public List<Employee> addEmployee(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestBody Employee employee) 
                 throws Exception 
    {       
    	empRepo.save(employee);
    	return empRepo.findAll();
        /*//Generate resource id
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
        
        //add resource
        employeeDao.addEmployee(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();*/
    }
}
