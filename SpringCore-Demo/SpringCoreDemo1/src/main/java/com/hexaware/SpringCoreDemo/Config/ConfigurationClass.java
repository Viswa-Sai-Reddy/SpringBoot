package com.hexaware.SpringCoreDemo.Config;

import com.hexaware.SpringCoreDemo.Common.Coach;
import com.hexaware.SpringCoreDemo.Common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
