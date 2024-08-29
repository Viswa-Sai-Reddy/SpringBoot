package com.Employee.CurdAPI.DAO;
import java.util.List;
import com.Employee.CurdAPI.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByFirstNameAsc();

}
