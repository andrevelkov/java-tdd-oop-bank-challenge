package com.booleanuk.core;

import com.booleanuk.core.Users.BankManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private List<Transaction> transactionList = new ArrayList<>();
    private BankManager bm;
    private String accountId;
    private String accountType;
    private String branch;
    private int balance = 0;

    public Account(String accountType, int balance, String branch, BankManager bm) {
        this.accountId = UUID.randomUUID().toString();
        this.branch = branch;
        this.bm = bm;
        setAccountType(accountType);
        checkBalance(balance);
    }

    public Account(String accountType, int balance, String branch) {
        this.accountId = UUID.randomUUID().toString();
        this.branch = branch;
        setAccountType(accountType);
        checkBalance(balance);
    }

    public Account(String accountId, String accountType) {
        this.accountId = UUID.randomUUID().toString();
        setAccountType(accountType);
        checkBalance(balance);
    }

    public void checkBalance(int balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Initial balance cant be less than 0");
        else
            setBalance(balance);
    }

    public int deposit(int amount) {
        if (amount <= 0){
            System.out.println("Deposit must be larger than 0..");
            return 0;
        }
        addTransaction(amount, "debit");
        return this.balance += amount;
    }

    public int withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Cant withdraw a negative value..");
            return 0;
        }

        if (this.balance >= amount) {
            balance -= amount;
            addTransaction(amount, "credit");
            return amount;
        } else {
            System.out.println("Cant withdraw amount, balance too low..");
            return 0;
        }
    }

    public void addTransaction(int amount, String type) {

        if (!type.toLowerCase().trim().equals("debit") && !type.toLowerCase().trim().equals("credit")) {
            type = "unknown";
        }

        LocalDate today = LocalDate.now();
        Transaction transaction = new Transaction(amount, this.balance, today, type); // amount, date, type
        transactionList.add(transaction);
    }

    public void generateBankStatement() {
        System.out.printf("\n%-20s %-10s %-10s %-10s\n", "Date", "Credit", "Debit", "Balance");

        for (Transaction t : transactionList) {
            if (t.getType().equals("debit")) {
                System.out.printf("%-20s %-10s %-10s %-10s\n", t.getDate(), " ", t.getAmount(), t.getBalance());
            } else if (t.getType().equals("credit")) {
                System.out.printf("%-20s %-10s %-10s %-10s\n", t.getDate(), t.getAmount(), " ", t.getBalance());
            }
        }
        System.out.println("\n");
    }

    public void genereateStatementForSMS() {
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Date", "Credit", "Debit", "Balance");
        for (Transaction t : transactionList) {
            if (t.getType().equals("debit")) {
                System.out.printf("%-10s %-10s %-10s %-10s\n", t.getDate().getMonth(), " ", t.getAmount(), t.getBalance());
            } else if (t.getType().equals("credit")) {
                System.out.printf("%-10s %-10s %-10s %-10s\n", t.getDate().getMonth(), t.getAmount(), " ", t.getBalance());
            }
        }
    }

    public boolean requestOverdraft(int amount) {
        return bm.verifyOverdraftRequest(this, amount);
    }

    // GETTERS & SETTERS

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
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
        switch (accountType) {
            case "savings", "current":
                this.accountType = accountType;
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + accountType);
        }
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

}
