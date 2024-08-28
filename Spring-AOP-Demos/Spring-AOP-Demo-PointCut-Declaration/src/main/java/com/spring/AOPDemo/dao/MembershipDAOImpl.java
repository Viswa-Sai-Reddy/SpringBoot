package com.spring.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addMembershipAccount() {
        System.out.println(getClass()+" Doing my DB work : Adding an MemberShip Account");
        return true;
    }
}
