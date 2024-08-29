package com.Employee.CurdAPI.Service;

import com.Employee.CurdAPI.DAO.EmployeeImpl;
import com.Employee.CurdAPI.Entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeImpl employee;

    public EmployeeServiceImpl(EmployeeImpl employee) {
        this.employee = employee;
    }

    @Override
    public List<Employee> findAll() {
        return employee.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employee.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employee.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employee.deleteById(id);
    }


}
