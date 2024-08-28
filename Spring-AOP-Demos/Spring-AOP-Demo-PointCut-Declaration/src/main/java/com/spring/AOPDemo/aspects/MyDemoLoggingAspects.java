package com.spring.AOPDemo.aspects;

import com.spring.AOPDemo.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspects {

    @Around("execution(* *.getFortune(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Log the advice method
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=======================> @Executing @Around on method: " + method);
        //get begin timestamp
        long start = System.currentTimeMillis();
        //execute the method
        Object result =null;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = "Road is blocked, so use Airlines";
//            throw e;
        }
        //get end timestamp
        long end = System.currentTimeMillis();
        //compute duration and display it
        long duration = end - start;
        System.out.println("The total Duration: " + duration / 1000 + "seconds");
        return result;
    }

    //Adding @After Advice
    @After("execution(* *.findAccounts(..))")
    public void afterFinallyAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======================> @Executing @After (finally) on method: " + method);
    }

    //Adding Advice afterThrowing
    @AfterThrowing(pointcut = "execution(* *.findAccounts(..))", throwing = "theExp")
    public void adviceAfterThrowingException(JoinPoint theJoinPoint, Throwable theExp) {
        //Log the advice method
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======================> @Executing @AfterThrowing on method: " + method);
        //Log the exception
        System.out.println("\n ------------------> The exception : " + theExp);
    }

    // adding advise after returning
    @AfterReturning(pointcut = "execution(* *.findAccounts(..))", returning = "result")
    public void afterReturningFindAccounts(JoinPoint theJoinPoint, List<Account> result) {
        //print on which method we are using afterReturning
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======================> @Executing @AfterReturning on method: " + method);

        convertFirstNameIntoUpperCase(result);
        System.out.println("\n=============================> Results: " + result);
    }

    private void convertFirstNameIntoUpperCase(List<Account> result) {
        for (Account ele : result) {
            String name = ele.getFirstName().toUpperCase();
            ele.setFirstName(name);
        }
    }

    @Before("com.spring.AOPDemo.aspects.AOPExpressions.forAllAOPNOGetterSetter()")
    public void beforeAddAccountAdvise(JoinPoint theJoinPoint) {
        System.out.println("\n===============>>>>> Executing @Before Advise on methods");

        //Display the method signature
        MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method Signature: " + signature);

        //Display the method arguments

        //get Args
        Object[] args = theJoinPoint.getArgs();
        //display args
        Arrays.stream(args).forEach(System.out::println);
    }
}