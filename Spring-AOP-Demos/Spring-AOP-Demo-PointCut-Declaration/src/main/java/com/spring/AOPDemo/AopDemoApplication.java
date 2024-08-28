package com.spring.AOPDemo;

import com.spring.AOPDemo.dao.Account;
import com.spring.AOPDemo.dao.AccountDAO;
import com.spring.AOPDemo.dao.MembershipDAO;
import com.spring.AOPDemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, TrafficFortuneService trafficFortuneService, MembershipDAO theMembershipDao) {
        return runner -> {
//			  addingAccountBeforeAdvise(theAccountDao,theMembershipDao);
//            demoAfterReturningAdvise(theAccountDao);
//            demoAfterThrowingExcpAdvise(theAccountDao);
//            afterFinallyAdvice(theAccountDao);
//            demoTheAroundAdvice(trafficFortuneService);
//            theAroundAdviceExceptionHandle(trafficFortuneService);
            AroundAdviceReThrowException(trafficFortuneService);
        };
    }

    private void AroundAdviceReThrowException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\n Main APP: demoTheAroundAdvice");
        boolean tripWire = true;
        String fortune = trafficFortuneService.getFortune(tripWire);
        System.out.println("My fortune: "+fortune);
        System.out.println("Finished");
    }

    private void theAroundAdviceExceptionHandle(TrafficFortuneService trafficFortuneService) {
        System.out.println("\n Main APP: demoTheAroundAdvice");
        boolean tripWire = true;
        String fortune = trafficFortuneService.getFortune(tripWire);
        System.out.println("My fortune: "+fortune);
        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

        System.out.println("\n Main APP: demoTheAroundAdvice");
        String fortune = trafficFortuneService.getFortune();
        System.out.println("My fortune: "+fortune);
        System.out.println("Finished");
    }

    private void afterFinallyAdvice(AccountDAO theAccountDao) {
        List<Account> accountList = null;
        try {
            boolean tripWire = false;
            accountList = theAccountDao.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\n Main Program : ....Exception thrown: "+e);
        }


        System.out.println("Main Program: There are the accounts.");
        System.out.println(accountList);
        System.out.println("The END!");
    }

    private void demoAfterThrowingExcpAdvise(AccountDAO theAccountDao) {

        List<Account> accountList = null;
        try {
            boolean tripWire = true;
            accountList = theAccountDao.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\n Main Program : ....Exception thrown: "+e);
        }


        System.out.println("Main Program: There are the accounts.");
        System.out.println(accountList);
        System.out.println("The END!");
    }

    private void demoAfterReturningAdvise(AccountDAO theAccountDao) {
        List<Account> accountList = theAccountDao.findAccounts();

        System.out.println("Main Program: There are the accounts.");
        System.out.println(accountList);
        System.out.println("The END!");
    }

    private void addingAccountBeforeAdvise(AccountDAO theAccountDao, MembershipDAO theMembershipDao) {
        theAccountDao.addAccount(true);

        //Calling Getter/Setter from AccountDAO
        theAccountDao.setFirstName("Viswa");
        theAccountDao.setLastName("Sai");
        theAccountDao.getFirstName();
        theAccountDao.getLastName();

        theMembershipDao.addMembershipAccount();
    }

}
