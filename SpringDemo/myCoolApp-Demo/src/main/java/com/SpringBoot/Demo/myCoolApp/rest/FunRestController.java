package com.SpringBoot.Demo.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties for : team.name

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hi Viswa!";
    }

    @GetMapping("/workouts")
    public String getWorkouts() {
        return "Run daily 5K!";
    }

    @GetMapping("/teaminfo")
    public String getTeamName() {
        return "Team Name: " + teamName;
    }
}
