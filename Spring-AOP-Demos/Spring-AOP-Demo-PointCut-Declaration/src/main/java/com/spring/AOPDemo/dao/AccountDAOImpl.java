package com.spring.AOPDemo.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String firstName;
    private String lastName;

    @Override
    public void addAccount(boolean flag) {
        System.out.println(getClass()+" Doing my DB work : Adding an Account");
    }

    public String getFirstName() {
        System.out.println(getClass()+" in getFirstName()");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println(getClass()+" in setFirstName()");
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println(getClass()+" in getLastName()");
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println(getClass()+" in setLastName()");
        this.lastName = lastName;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("There is no data to you....!");
        }

        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account("Viswa","Sai");
        Account account2 = new Account("Vamsi","Krishan");
        Account account3 = new Account("Gowtham","Sagar");

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        return accountList;
    }
}
