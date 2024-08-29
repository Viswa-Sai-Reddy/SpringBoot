package com.Employee.CurdAPI.Controller;

import com.Employee.CurdAPI.Entity.Employee;
import com.Employee.CurdAPI.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        //get employees from db
        List<Employee> employeeList = employeeService.findAll();
        //add it to the model
        model.addAttribute("employeeList",employeeList);

        return "employees/listEmployees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employees/employeeForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        //to prevent duplicate submission redirect to employee list
            return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model){
        Employee theEmployee = employeeService.findById(id);
        model.addAttribute("employee",theEmployee);

        return "employees/employeeForm";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

}
