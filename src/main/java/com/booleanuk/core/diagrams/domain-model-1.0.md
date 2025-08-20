# Core

| **Class**       | **Member**          | **Method**                    | **Scenario**                                                             | **Output**    |
|-----------------|---------------------|-------------------------------|--------------------------------------------------------------------------|---------------|
| **Customer**    | `customerId`        | `createACurrentAccount()`     | As a customer, I want to create a current account.                       | `bool`        |
|                 | `List<Account>`     | `createASavingsAccount()`     | As a customer, I want to create a savings account.                       | `bool`        |
|                 | ``                  | `depositToSavings()`          | As a customer, I want to deposit to a savings account.                   | `bool`        |
|                 | ``                  | `depositToCurrent()`          | As a customer, I want to deposit to a current account.                   | `bool`        |
|                 | ``                  | `withdrawFromCurrent()`       | As a customer, I want to withdraw from current.                          | `int`         |
|                 | ``                  | `withdrawFromSavings()`       | As a customer, I want to withdraw from svaings.                          | `int`         |
| **Account**     | `accountId`         | `deposit(amount)`             | As a customer, I want to deposit funds.                                  | `boolean`     |
|                 | `balance`           | `withdraw(amount)`            | As a customer, I want to withdraw funds.                                 | `boolean`     |
|                 | `accountType`       | `generateBankStatement()`     | As a customer, I want to generate bank statements.                       | `void`        |
|                 | `List<Transaction>` | `addTransaction(transaction)` | On account transaction, store the data for future statement.             | `void`        |
| **Transaction** | `transactionId`     | `getTransactionDetails()`     | As a customer, I want to view a transaction.                             | `Transaction` |
|                 | `amount`            | `getTransactionAmount()`      | As a customer, I want to see the transaction amount.                     | `decimal`     |
|                 | `date`              | `getTransactionDate()`        | As a customer, I want to see the date of the transaction.                | `Date`        |
|                 | `type`              | `getTransactionType()`        | As a customer, I want to see the type (debit/credit) of the transaction. | `type`        |

# Extensions 

| **Class**       | **Member**                                                  | **Method**                        | **Scenario**                                                                       | **Output**                                             |
|-----------------|-------------------------------------------------------------|-----------------------------------|------------------------------------------------------------------------------------|--------------------------------------------------------|
| **Engineer**    | `List<Account> accounts`                                    | `getAccountBalance()`             | As an engineer, I want account balances to be calculated from transaction history. | Returns balance amount                                 |
| **BankManager** | `List<Branch> branches`                                     | `-`                               | As a bank manager, I want accounts to be associated with specific branches.        | **`BankManager` contains a list of `Branch` objects.** |
|                 |                                                             | `verifyOverdraftRequest(account)` | As a bank manager, I want to approve/reject overdraft requests.                    | `boolean`                                              |
| **Customer**    | `-`                                                         | `requestOverdraft(account)`       | As a customer, I want to request an overdraft on my account.                       | `boolean`                                              |
|                 |                                                             |                                   |                                                                                    |                                                        |
| **Branch**      | `branchId`, `location`, `List<Account> accounts` | `-`                               | As a bank manager, I want accounts to be associated with specific branches.        |                                                        |


// Notes:
Extension:

User (Abstract?) - Customer, Manager (though they currently do not share anything)

Engineer story
    want balances acounted based on history instaed of memoery
    -> no member variable -> calculate from history of transaction list on each call ?

BankManager
    Accounts -> associate with Branches 
        Branches (parent) -> Branch
    Approve or Reject overdraft Request

Customer
    Emergency fund -> overdraft request on account
