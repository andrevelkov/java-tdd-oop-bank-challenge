package com.booleanuk.core;

import com.booleanuk.core.Users.Customer;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testForStatementPrintout() {
        Customer c = new Customer();
        c.createAccount(2, "savings", 500);
        c.depositToAccount(300);
        c.depositToAccount(100);
        c.withdrawFromAccount(150);
        c.depositToAccount(500);
        c.withdrawFromAccount(400);

        c.viewBankStatements();
    }
}
