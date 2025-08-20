package com.booleanuk.core.Users;

import com.booleanuk.core.Account;
import com.booleanuk.core.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BankManager {
    private String id;
    List<Branch> branches = new ArrayList<>();

    public BankManager() {
        this.id = UUID.randomUUID().toString();
    }

    // Approve if within balance range, if above double balance, deny
    public Boolean verifyOverdraftRequest(Account account, int amount) {

        return null;
    }

}
