package com.booleanuk.core;

import com.booleanuk.core.Users.BankManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankManagerTest {

    @Test
    public void ifBalanceAboveThresholdApproveOverdraftElseDeny() {
        Account acc = new Account("current", 1000, "rome");
        BankManager bm = new BankManager();

        assertTrue(bm.verifyOverdraftRequest(acc, 1000));
        assertTrue(bm.verifyOverdraftRequest(acc, 999));
        assertFalse(bm.verifyOverdraftRequest(acc, 1100));
        assertFalse(bm.verifyOverdraftRequest(acc, 1001));
        assertTrue(bm.verifyOverdraftRequest(acc, 500));
        assertTrue(bm.verifyOverdraftRequest(acc, 0));
        assertFalse(bm.verifyOverdraftRequest(acc, -1000));
    }

    @Test
    public void addBranchesAndVerify() {
        BankManager bm = new BankManager();
        Branch b1 = bm.addBranch("rome");
        Branch b2 = bm.addBranch("berlin");

        Account acc = new Account("current", 1000, "rome");
        Account acc2 = new Account("current", 2000, "berlin");
        Account acc3 = new Account("current", 4000, "rome");
        Account acc4 = new Account("current", 6000, "rome");

        bm.addAccountToBranch(acc);
        bm.addAccountToBranch(acc2);
        bm.addAccountToBranch(acc3);
        bm.addAccountToBranch(acc4);

        List<Branch> list = bm.getBranches();
        assertEquals("rome", list.getFirst().getLocation());
        assertEquals("berlin", list.getLast().getLocation());

        List<Account> accs = list.getFirst().getAccounts();
        assertEquals("rome", accs.getFirst().getBranch());
        assertEquals("rome", accs.get(1).getBranch());
        assertEquals("rome", accs.get(2).getBranch());
    }

}
