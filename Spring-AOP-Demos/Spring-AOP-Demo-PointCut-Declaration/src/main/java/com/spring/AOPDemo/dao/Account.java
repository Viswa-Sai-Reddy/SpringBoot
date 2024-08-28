package com.spring.AOPDemo.dao;

public class Account {
    private String firstName;
    private String lastName;

    public Account() {
    }

    public Account(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
