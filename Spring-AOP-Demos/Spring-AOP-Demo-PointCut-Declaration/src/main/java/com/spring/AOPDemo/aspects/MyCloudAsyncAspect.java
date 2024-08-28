package com.spring.AOPDemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudAsyncAspect {
    @Before("com.spring.AOPDemo.aspects.AOPExpressions.forAllAOPNOGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n===============>>>>> Log to Clouds");
    }
}
