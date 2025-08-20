package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testCreateCurrentAccountWithDataPassVerifications() {
        Account acc = new Account(1, "savings", 500);
        assertEquals("savings", acc.getAccountType());
        assertEquals(500, acc.getBalance());
        assertThrows(IllegalArgumentException.class, () -> acc.setAccountType("test"));
        assertThrows(IllegalArgumentException.class, () -> acc.setBalance(-530));
    }

    @Test
    public void depositAndUpdateAccountBalance() {
        Account acc = new Account(1, "savings", 444);

        assertTrue(acc.deposit(5000));
        assertEquals(5444, acc.getBalance());
        assertTrue(acc.deposit(54));
        assertEquals(6000, acc.getBalance());
        assertFalse(acc.deposit(-54));
        assertFalse(acc.deposit(0));
    }

    @Test
    public void withdrawAndUpdateAccountBalance() {
        Account acc = new Account(1, "savings", 444);

        assertTrue(acc.withdraw(400));
        assertEquals(44, acc.getBalance());
        assertTrue(acc.deposit(54));
        assertTrue(acc.withdraw(4));
        assertEquals(94, acc.getBalance());
    }

    @Test
    public void withdrawLessThanBalance() {
        Account acc = new Account(1, "savings", 444);

        assertFalse(acc.withdraw(1000));
        assertFalse(acc.withdraw(-1000));
        assertFalse(acc.withdraw(0));
        assertTrue(acc.withdraw(44));
        assertTrue(acc.withdraw(400));
        assertFalse(acc.withdraw(1));
    }

}
