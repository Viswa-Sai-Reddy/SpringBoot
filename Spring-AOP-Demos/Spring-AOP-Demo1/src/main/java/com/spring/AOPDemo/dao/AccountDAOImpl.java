package com.spring.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(boolean flag) {
        System.out.println(getClass()+" Doing my DB work : Adding an Account");
    }
}
