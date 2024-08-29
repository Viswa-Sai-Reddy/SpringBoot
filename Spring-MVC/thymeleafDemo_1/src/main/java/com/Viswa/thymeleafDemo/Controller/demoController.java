package com.Viswa.thymeleafDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class demoController {

    @GetMapping("/")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDateTime",LocalDateTime.now());

        return "helloWorld";
    }
}
