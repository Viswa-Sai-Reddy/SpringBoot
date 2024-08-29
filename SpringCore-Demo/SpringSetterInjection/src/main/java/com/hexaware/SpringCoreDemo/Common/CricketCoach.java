package com.hexaware.SpringCoreDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run 5K in the morning and evening .";
    }
}
