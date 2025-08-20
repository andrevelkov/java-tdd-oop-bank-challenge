package com.booleanuk.core.Users;

import com.booleanuk.core.Account;

import java.util.UUID;

public class Customer {
    private String id;
    private Account account;

    public Customer() {
        this.id = UUID.randomUUID().toString();
    }

    public void createAccount(String type, int balance, String branch) {
        this.account = new Account(type, balance, branch);
    }

    // Mainly for testing interaction , Customer -> Account -> BankManager
    public void createAccount(String type, int balance, String branch, BankManager bm) {
        this.account = new Account(type, balance, branch, bm);
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

    public boolean requestOverdraft(int amount) {
        return account.requestOverdraft(amount);
    }

    public void sendStatementAsSMS(String num) {
        System.out.println("\n\nSend to number: " + num);
        System.out.println("Sending SMS...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("\nIncoming...");
        account.genereateStatementForSMS();
        System.out.println("\n");
    }

}
