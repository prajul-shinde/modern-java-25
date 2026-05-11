record Money(double amount, String currency) {

    Money {
        if (amount < 0)
            throw new IllegalArgumentException("amount cannot be negative");
        if (currency == null || currency.isBlank())
            throw new IllegalArgumentException("Currency cannot be null or blank");
    }

    public Money add(Money other) {
        if (!other.currency.equals(this.currency))
            throw new IllegalArgumentException("cannot add different currencies : %s and %s".formatted(this.currency, other.currency));
        else return new Money(this.amount + other.amount, this.currency);
    }

    public String format() {
        return "%s %.2f".formatted(currency, amount);
    }

    public static Money zero(String currency) {
        return new Money(0, currency);
    }
}

void main() {
    System.out.println("--- Money Record Test ---");

    // Test: Create two Money objects and add them
    Money m1 = new Money(250.00, "INR");
    Money m2 = new Money(50.50, "INR");
    Money result = m1.add(m2);

    System.out.println("Result of addition: " + result.format());

    // Test: Try invalid currency (null/blank)
    System.out.println("\n--- Testing Invalid Currency ---");
    try {
        new Money(100, "");
    } catch (IllegalArgumentException e) {
        System.out.println("Caught: " + e.getMessage());
    }

    // Test: Try negative amount
    System.out.println("\n--- Testing Negative Amount ---");
    try {
        new Money(-5, "USD");
    } catch (IllegalArgumentException e) {
        System.out.println("Caught: " + e.getMessage());
    }

    // Test: Different currencies
    System.out.println("\n--- Testing Mismatched Currencies ---");
    try {
        Money usd = new Money(10, "USD");
        m1.add(usd);
    } catch (IllegalArgumentException e) {
        System.out.println("Caught: " + e.getMessage());
    }

    // Test: Zero factory
    Money zeroYen = Money.zero("JPY");
    System.out.println("\nZero Factory: " + zeroYen.format());
}