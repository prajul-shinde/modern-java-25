import static java.lang.IO.println;

void main() {

    BankAccount account = new BankAccount(100.00);
    account.deposit(100);
    account.withdraw(200);
    println(account.getBalance());
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0)
            this.balance += amount;
        else throw new IllegalArgumentException("amount must be greater than 0");
    }

    double withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return amount;
        } else throw new IllegalArgumentException("amount must be greater than 0 and less than balance");
    }

    double getBalance() {
        return balance;
    }
}