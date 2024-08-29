package com.Employee.CurdAPI.rest;

import com.Employee.CurdAPI.Entity.Employee;
import com.Employee.CurdAPI.Service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImpl employee;

    //Constructor Injection
    public EmployeeRestController(EmployeeServiceImpl employeeImpl) {
        employee = employeeImpl;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employee.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId){

//        if((employeeId > employee.findAll().size()) || (employeeId <= 0))
//            return throw new EmployeeNotFound("Employee not found with Id: "+employeeId);

        Employee theEmployee = employee.findById(employeeId);
        if(theEmployee == null)
            throw new RuntimeException("No employee found with id: "+employeeId);

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee){
        return employee.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employee.save(theEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee1 = employee.findById(id);

        if(employee1 == null)
            throw new RuntimeException("No employee with id: "+id);
        employee.deleteById(id);
        return "Employee with id: "+id+" is deleted";
    }

}
