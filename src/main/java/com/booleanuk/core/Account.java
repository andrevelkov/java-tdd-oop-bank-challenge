package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Account {
    private String accountId;
    private int balance = 0;
    private String accountType;
    private List<Transaction> transactionList = new ArrayList<>();

    public Account(String accountType, int balance) {
        this.accountId = UUID.randomUUID().toString();
        setAccountType(accountType);

        if (balance < 0)
            throw new IllegalArgumentException("Initial balance cant be less than 0");
        else
            setBalance(balance);
    }

    public Account(String accountId, String accountType) {
        this.accountId = UUID.randomUUID().toString();
        setAccountType(accountType);
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
//        System.out.println(today);
//        Date today = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = sdf.format(today);

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

    // GETTERS & SETTERS

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
