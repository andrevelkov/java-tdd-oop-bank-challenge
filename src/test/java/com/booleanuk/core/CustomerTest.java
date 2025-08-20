package com.booleanuk.core;

import com.booleanuk.core.Users.BankManager;
import com.booleanuk.core.Users.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test   // Testing printout of method
    public void testForStatementPrintout() {

        Customer c = new Customer();
        c.createAccount("savings", 500, "rome");
        c.depositToAccount(300);
        c.depositToAccount(100);
        c.withdrawFromAccount(150);
        c.depositToAccount(500);
        c.withdrawFromAccount(400);

        c.viewBankStatements();
    }

    @Test
    public void testRequestOverdraft() {
        BankManager bm = new BankManager();
        Customer c = new Customer();
        c.createAccount("current", 500, "rome", bm);
        assertTrue(c.requestOverdraft(500));
        assertTrue(c.requestOverdraft(499));
        assertTrue(c.requestOverdraft(1));
        assertFalse(c.requestOverdraft(1000));
        assertFalse(c.requestOverdraft(1001));
        assertFalse(c.requestOverdraft(-151));
    }

    @Test       // Testing printout of method
    public void sendStatementAsSMS() {
        Customer c = new Customer();
        c.createAccount("savings", 500, "rome");
        c.depositToAccount(300);
        c.depositToAccount(100);
        c.withdrawFromAccount(150);
        c.depositToAccount(500);
        c.withdrawFromAccount(400);

        c.sendStatementAsSMS("0708616843");
    }
}
