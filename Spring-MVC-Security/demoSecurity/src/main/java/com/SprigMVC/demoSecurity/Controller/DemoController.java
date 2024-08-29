package com.SprigMVC.demoSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
     return "home";
    }

    @GetMapping("/leaders")
    public String showLeadersPage(){
        return "leadersPage";
    }

    @GetMapping("/systems")
    public String showSystemPage(){
        return "systemPage";
    }
}
