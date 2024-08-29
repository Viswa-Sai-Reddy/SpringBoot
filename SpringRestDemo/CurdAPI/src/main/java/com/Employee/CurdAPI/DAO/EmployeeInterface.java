package com.Employee.CurdAPI.DAO;

import com.Employee.CurdAPI.Entity.Employee;
import java.util.*;

public interface EmployeeInterface {
    List<Employee> findAll();

    Employee findById(int id);
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
