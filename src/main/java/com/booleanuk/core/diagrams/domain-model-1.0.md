Class , member , method , scenario, output

| Class       |   Member  |       Method            |   Scenario           | Output  |
| Customer    |           | createACurrentAccount() | Create a current acc | boolean |
|             |           | createASavingsAccount() | Create a savings acc | boolean |
|             |           | createASavingsAccount() | Create a savings acc | boolean |



| **Class**       | **Member**                   | **Method**                    | **Scenario**                                                             | **Output**    |
| --------------- |------------------------------|-------------------------------|--------------------------------------------------------------------------|---------------|
| **Customer**    | `customerId`                 | `createACurrentAccount()`     | As a customer, I want to create a current account.                       | `bool`        |
|                 | `List<Account>`              | `createASavingsAccount()`     | As a customer, I want to create a savings account.                       | `bool`        |
|                 | ``                           | `depositToSavings()`          | As a customer, I want to deposit to a savings account.                   | `bool`        |
|                 | ``                           | `depositToCurrent()`          | As a customer, I want to deposit to a current account.                   | `bool`        |
|                 | ``                           | `withdrawFromCurrent()`       | As a customer, I want to withdraw from current.                          | `int`         |
|                 | ``                           | `withdrawFromSavings()`       | As a customer, I want to withdraw from svaings.                          | `int`         |
| **Account**     | `accountId`                  | `deposit(amount)`             | As a customer, I want to deposit funds.                                  | `boolean`     |
|                 | `balance`                    | `withdraw(amount)`            | As a customer, I want to withdraw funds.                                 | `boolean`     |
|                 | `accountType`                | `generateBankStatement()`     | As a customer, I want to generate bank statements.                       | `void`        |
|                 | ``                           | `createCurrentAccount()`      | As a customer, I want to create a current account.                       | `void`        |
|                 | ``                           | `createSavingsAccount()`      | As a customer, I want to create a savings account.                       | `void`        |
|                 | `HashMap<Date, Transaction>` | `addTransaction(transaction)` | On account transaction, store the data for future statement.             | `void`        |
| **Transaction** | `transactionId`              | `getTransactionDetails()`     | As a customer, I want to view a transaction.                             | `Transaction` |
|                 | `amount`                     | `getTransactionAmount()`      | As a customer, I want to see the transaction amount.                     | `decimal`     |
|                 | `date`                       | `getTransactionDate()`        | As a customer, I want to see the date of the transaction.                | `Date`        |
|                 | `type`                       | `getTransactionType()`        | As a customer, I want to see the type (debit/credit) of the transaction. | `type`        |

[//]: # (TODO: remove create account from Account class)