package com.Viswa.thymeleafDemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldForm {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloWorld-Form";
    }

    @GetMapping("/processForm")
    public String processForm() {
        return "helloWorld_Student";
    }

    @GetMapping("/processFormVersionTwo")
    public String getUpperCase(HttpServletRequest request, Model model){
        //Read the data from HTML page
        String theName = request.getParameter("studentName");

        //Convert into UpperCase
        theName = theName.toUpperCase();

        //Add date to model
        model.addAttribute("message",theName);

        return "helloWorld";
    }

    @PostMapping("/processFormVersionThree")
    public String getUpperCaseForm(@RequestParam("studentName") String theName, Model model){

        //Convert into UpperCase
        theName = theName.toUpperCase();

        //Add date to model
        model.addAttribute("message",theName);

        return "helloWorld";
    }
}