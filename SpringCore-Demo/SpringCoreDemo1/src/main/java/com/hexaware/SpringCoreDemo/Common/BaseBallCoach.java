package com.hexaware.SpringCoreDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your throwing ball";
    }
}
