package com.spring.AOPDemo.dao;

import java.util.*;

public interface AccountDAO {
    void addAccount(boolean flag);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
