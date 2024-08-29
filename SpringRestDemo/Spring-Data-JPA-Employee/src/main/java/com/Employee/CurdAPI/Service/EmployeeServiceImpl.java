package com.Employee.CurdAPI.Service;

import com.Employee.CurdAPI.DAO.EmployeeRepository;
import com.Employee.CurdAPI.Entity.Employee;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent())
            return result.get();
        else
            throw new RuntimeException("No employee with id: "+id);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


}
