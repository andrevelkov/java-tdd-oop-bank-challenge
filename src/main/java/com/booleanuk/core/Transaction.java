package com.booleanuk.core;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String id;
    private int amount;
    private LocalDate date;
    private String type;
    private int balance;

    public Transaction(int amount, int balance, LocalDate date, String type) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.balance = balance;
        this.date = date;
        this.type = type;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
