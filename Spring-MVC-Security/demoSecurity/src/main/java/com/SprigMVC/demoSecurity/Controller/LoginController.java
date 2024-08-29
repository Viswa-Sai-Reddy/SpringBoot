package com.SprigMVC.demoSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginForm() {
        return "fancy-login";
//        return "loginPage";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied() {
        return "accessDenied";
    }

    @GetMapping("/register/registerForm")
    public String showRegistrationForm() {
        return "registrationForm";
    }
}
