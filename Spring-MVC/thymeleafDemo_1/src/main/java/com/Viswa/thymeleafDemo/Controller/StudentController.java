package com.Viswa.thymeleafDemo.Controller;

import com.Viswa.thymeleafDemo.Model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${operatingSystem}")
    private List<String> operatingSystem;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        //Create Student Instance
        Student student = new Student();

        //add to the model
        model.addAttribute("student", student);
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("operatingSystem",operatingSystem);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String showStudentDetails(@ModelAttribute("student") Student theStudent){

        //log the details
        System.out.println("Student : "+theStudent.getFirstName() +" "+ theStudent.getLastName());

        return "student-conformation";
    }
}
