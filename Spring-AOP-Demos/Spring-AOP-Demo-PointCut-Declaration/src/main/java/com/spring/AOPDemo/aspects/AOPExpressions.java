package com.spring.AOPDemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
    @Pointcut("execution(void  com.spring.AOPDemo.dao.AccountDAOImpl.addAccount())")
    public void fullAdvice() {}

    @Pointcut("execution(* com.spring.AOPDemo.dao.*.*(..))")
    public void forAllAOPDemo(){}

    @Pointcut("execution(* com.spring.AOPDemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.spring.AOPDemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forAllAOPDemo() && !(setter() || getter())")
    public void forAllAOPNOGetterSetter(){}

    @Pointcut("execution(void add*())")
    public void startWithAdd(){}

    @Pointcut("execution(* add*(..))")
    public void forNParams(){}

    @Pointcut("execution(* add*(*))")
    public void forOneParam(){}
}
