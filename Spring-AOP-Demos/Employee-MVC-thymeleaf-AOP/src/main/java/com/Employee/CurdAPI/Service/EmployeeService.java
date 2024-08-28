package com.Employee.CurdAPI.Service;

import com.Employee.CurdAPI.Entity.Employee;
import java.util.*;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);
    void deleteById(int id);
}
