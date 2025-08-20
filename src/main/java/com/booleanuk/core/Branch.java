package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Branch {
    private String id;
    private String name;
    private String location;
    private List<Account> accounts = new ArrayList<>();

    public Branch(String location, String name) {
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
