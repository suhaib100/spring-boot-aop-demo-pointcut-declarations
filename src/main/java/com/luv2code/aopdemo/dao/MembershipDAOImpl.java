package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addSillyMethod() {
        System.out.println(getClass()+ " : Doing my db work : adding a membership account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+ " : i am going to sleep now...");

    }
}
