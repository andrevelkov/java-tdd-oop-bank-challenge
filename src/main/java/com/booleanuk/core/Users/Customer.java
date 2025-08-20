package com.booleanuk.core.Users;

import com.booleanuk.core.Account;

import java.util.UUID;

public class Customer {
    private String id;
    private Account account;

    public Customer() {
        this.id = UUID.randomUUID().toString();
    }

    public void createAccount(int id, String type, int balance) {
        this.account = new Account(type, balance);
    }

    public void viewBankStatements() {
        this.account.generateBankStatement();
    }

    public void depositToAccount(int amount) {
        this.account.deposit(amount);
    }

    public void withdrawFromAccount(int amount) {
        this.account.withdraw(amount);
    }
}
