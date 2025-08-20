package com.booleanuk.core.Users;

import com.booleanuk.core.Account;
import com.booleanuk.core.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Engineer {
    private String id;
    private List<Account> accountList = new ArrayList<>();

    public Engineer(List<Account> list) {
        this.id = UUID.randomUUID().toString();
        this.accountList = list;
    }

    public int getAccountBalance(String id) {
        Account account = null;
        for (Account a: accountList)
            if (a.getAccountId().equals(id))
                account = a;

        List<Transaction> list = null;
        if (account != null) {
            list = account.getTransactionList();
        }

        int balance = 0;
        if (list != null) {
            balance = list.getFirst().getBalance();

            for (Transaction t : list) {
                if (t.getType().equals("debit")) {
                    balance += t.getAmount();
                } else if (t.getType().equals("credit")) {
                    balance -= t.getAmount();
                }
            }
        }
        return balance;
    }
}
