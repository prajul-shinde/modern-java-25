void main() {
    Money wallet = new Money(25.5, "EUR");
    Money bank = new Money(25.5, "USD");
    Money different = new Money(10.0, "EUR");

    // Test toString()
    System.out.println("Formatted string: " + wallet); // Output: €25.50

    // Test equals() - ignoring currency
    System.out.println("Do wallet and bank match? " + wallet.equals(bank)); // Output: true
    System.out.println("Do wallet and different match? " + wallet.equals(different)); // Output: false

    // Testing the record components still work
    System.out.println("Original currency of bank: " + bank.currency());
}

record Money(double amount, String currency) {

    @Override
    public String toString() {
        return "€%.2f".formatted(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return Double.compare(amount, money.amount) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(amount);
    }
}