package com.spring.AOPDemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAPIAnalyticsAspects {

    @Before("com.spring.AOPDemo.aspects.AOPExpressions.forAllAOPNOGetterSetter()")
    public void performAPIAnalytics() {
        System.out.println("\n===============>>>>> Perform API Analytics");
    }
}
