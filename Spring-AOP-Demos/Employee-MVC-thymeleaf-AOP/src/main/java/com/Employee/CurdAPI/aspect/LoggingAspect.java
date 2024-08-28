package com.Employee.CurdAPI.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.Employee.CurdAPI.Controller.*.*(..))")
    public void forControllerAdvice() {
    }

    @Pointcut("execution(* com.Employee.CurdAPI.DAO.*.*(..))")
    public void forDaoAdvice() {
    }

    @Pointcut("execution(* com.Employee.CurdAPI.Service.*.*(..))")
    public void forServiceAdvice() {
    }

    @Pointcut("forControllerAdvice() || forDaoAdvice() || forServiceAdvice()")
    public void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        //Display the method
        String theMethod = theJoinPoint.getSignature().toString();
        System.out.println("----> @Before method Called: "+theMethod);

        //Display the arguments of method
        Object[] args = theJoinPoint.getArgs();

        for(Object tempObj : args)
            logger.info("====> Arguments: "+tempObj);

    }

    @AfterReturning(pointcut = "forAppFlow()", returning ="returns")
    public void after(JoinPoint theJoinPoint, Object returns){

        // print the method called
        String theMethod = theJoinPoint.getSignature().toString();
        System.out.println("----> @AfterReturning method Called: "+theMethod);

        //print the method arguments
        Object[] args = theJoinPoint.getArgs();
        for(Object tempArgs: args)
            logger.info("===> Arguments: "+tempArgs);
    }
}
