package com.spring.AOPDemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspects {

    //@Before Advise

//    @Before("execution(void  com.spring.AOPDemo.dao.AccountDAOImpl.addAccount())")
//    @Before("execution(void add*())")
    @Before("execution(* add*(..))")
    public void beforeAddAccountAdvise() {
        System.out.println("\n===============>>>>> Executing @Before Advise on methods");
    }
}
