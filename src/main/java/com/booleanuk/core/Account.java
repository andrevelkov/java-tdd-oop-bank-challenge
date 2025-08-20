package com.booleanuk.core;

import java.util.Date;
import java.util.HashMap;

public class Account {
    private int accountId;
    private int balance = 0;
    private String accountType;
    private HashMap<Date, Transaction> transactionHashMap = null;

    public Account(int accountId, String accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public Account(int accountId, String accountType, int balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Boolean deposit(int amount) {
        return null;
    }

    public Boolean withdraw(int amount) {
        return null;
    }

    public void addTransaction(int amount) {

    }

    // GETTERS & SETTERS

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public HashMap<Date, Transaction> getTransactionHashMap() {
        return transactionHashMap;
    }

    public void setTransactionHashMap(HashMap<Date, Transaction> transactionHashMap) {
        this.transactionHashMap = transactionHashMap;
    }

    public void generateBankStatement() {

    }

}
