package com.booleanuk.core;

import com.booleanuk.core.Users.BankManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankManagerTest {

    @Test
    public void ifBalanceAboveThresholdApproveOverdraftElseDeny() {

        Account acc = new Account("current", 1000);
        BankManager bm = new BankManager();
        assertTrue(bm.verifyOverdraftRequest(acc, 1000));
        assertTrue(bm.verifyOverdraftRequest(acc, 999));
        assertFalse(bm.verifyOverdraftRequest(acc, 1100));
        assertFalse(bm.verifyOverdraftRequest(acc, 1001));
        assertTrue(bm.verifyOverdraftRequest(acc, 500));
        assertTrue(bm.verifyOverdraftRequest(acc, 0));
        assertFalse(bm.verifyOverdraftRequest(acc, -1000));
    }

}
