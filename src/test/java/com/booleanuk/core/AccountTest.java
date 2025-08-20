package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testCreateCurrentAccountWithDataPassVerifications() {
        Account acc = new Account(1, "savings", 500);
        assertEquals("savings", acc.getAccountType());
        assertEquals(500, acc.getBalance());
        assertThrows(IllegalArgumentException.class, () -> acc.setAccountType("test"));
        assertThrows(IllegalArgumentException.class, () -> new Account(2, "current", -500));
    }

    @Test
    public void depositAndUpdateAccountBalance() {
        Account acc = new Account(1, "savings", 444);

        assertEquals(5444, acc.deposit(5000));
        assertEquals(5444, acc.getBalance());
        assertEquals(5500, acc.deposit(56));
        assertEquals(5500, acc.getBalance());
        assertEquals(0, acc.deposit(-54));
        assertEquals(0, acc.deposit(0));
    }

    @Test
    public void withdrawAndUpdateAccountBalance() {
        Account acc = new Account(1, "savings", 444);

        assertEquals(400 ,acc.withdraw(400));
        assertEquals(44, acc.getBalance());
        assertEquals(98, acc.deposit(54));
        assertEquals(4, acc.withdraw(4));
        assertEquals(94, acc.getBalance());
    }

    @Test
    public void withdrawLessThanBalance() {
        Account acc = new Account(1, "savings", 444);

        assertEquals(0, acc.withdraw(1000));
        assertEquals(0, acc.withdraw(-1000));
        assertEquals(0, acc.withdraw(0));
        assertEquals(44, acc.withdraw(44));
        assertEquals(400, acc.getBalance());
        assertEquals(400, acc.withdraw(400));
        assertEquals(0, acc.withdraw(1));
    }

    @Test
    public void createTransaction() {
        Account acc = new Account(1, "savings", 500);
        acc.addTransaction(500, ""); // unknown type
        acc.deposit(300); // deposit = debit

        List<Transaction> list = acc.getTransactionList();
        assertEquals(2, list.size());
        Transaction test = list.getFirst();
        Transaction test2 = list.getLast();
        assertEquals(500, test.getAmount());
        assertEquals("unknown", test.getType());
        assertEquals("debit", test2.getType());
        assertEquals(300, test2.getAmount());
    }

}
