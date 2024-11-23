package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;


    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+ " : Doing my db work : adding an account");
    }

    @Override
    public List<Account> findAccounts() {

return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("no soup for you...");
        }


        List<Account> myAccounts = new ArrayList<>();
        Account t1 = new Account("john","silver");
        Account t2 = new Account("madhu","platinum");
        Account t3 = new Account("luca","gold");

        myAccounts.add(t1);
        myAccounts.add(t2);
        myAccounts.add(t3);

        return myAccounts;



    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+ " : doWork()");
        return false;
    }


    public String getName() {

        System.out.println(getClass()+ " : in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+ " : in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+ " : in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+ " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
