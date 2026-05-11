class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            this.balance += amount;
        else
            throw new IllegalArgumentException("amount should be greater than 0");
    }

    public double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            return amount;
        } else throw new IllegalArgumentException("amount must be greater than 0 and less than equal to balance");
    }

    @Override
    public String toString() {
        return """
                BankAccount {
                 balance : %.2f
                }
                """.formatted(balance);
    }
}

void main() {

    System.out.println("--- Bank Account Operations Test ---");

    // Initialize account with a starting balance
    BankAccount account = new BankAccount(100.00);
    System.out.println("Initial State: " + account);

    // 1. Valid Deposit
    System.out.println("--- Test 1: Valid Deposit ---");
    System.out.println("Depositing $50.00...");
    account.deposit(50.00);
    System.out.println(account);

    // 2. Valid Withdrawal
    System.out.println("--- Test 2: Valid Withdrawal ---");
    System.out.println("Withdrawing $30.00...");
    account.withdraw(30.00);
    System.out.println(account);

    // 3. Invalid Amount (Catch the exception)
    System.out.println("--- Test 3: Invalid Deposit Amount ---");
    System.out.println("Attempting to deposit -$20.00...");
    try {
        account.deposit(-20.00);
    } catch (IllegalArgumentException e) {
        System.out.println("Exception Caught: " + e.getMessage());
    }
    System.out.println(account); // Balance remains unchanged

    // 4. Overdraft Attempt (Catch the exception)
    System.out.println("--- Test 4: Overdraft Attempt ---");
    System.out.println("Attempting to withdraw $500.00...");
    try {
        account.withdraw(500.00);
    } catch (IllegalArgumentException e) {
        System.out.println("Exception Caught: " + e.getMessage());
    }
    System.out.println(account); // Balance remains unchanged
}