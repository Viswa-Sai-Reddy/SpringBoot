package com.hexaware.SpringCoreDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Hard Run 5K!";
    }
}
