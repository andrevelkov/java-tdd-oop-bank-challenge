package com.booleanuk.core;

import com.booleanuk.core.Users.Engineer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class EngineerTest {

    @Test
    public void asEngineerCalculateAllHistoryTransactions() {

        Account account = new Account("current", 1000, "rome");
        account.deposit(500);
        account.withdraw(300);
        account.deposit(150);
        account.deposit(550);
        account.withdraw(1000);
        List<Account> list = new ArrayList<>();
        list.add(account);
        Engineer e = new Engineer(list);

        assertEquals(900, e.getAccountBalance(account.getAccountId())); // shall be 900
    }
}
