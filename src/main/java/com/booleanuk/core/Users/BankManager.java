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

    // True if within balance range, else deny
    public Boolean verifyOverdraftRequest(Account account, int amount) {
        if (amount < 0)
            return false;

        return amount <= account.getBalance();
    }

    public Branch addBranch(String branchLocation) {
        Branch branch = new Branch(branchLocation);
        branches.add(branch);

        return branch;
    }

    public void addAccountToBranch(Account account) {
        for (Branch branch : branches) {
            if (account.getBranch().equalsIgnoreCase(branch.getLocation())) {
                branch.addAccount(account);
                return;
            }
        }
    }

    public List<Branch> getBranches() {
        return this.branches;
    }
}
