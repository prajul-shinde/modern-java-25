// 1. Sealed Interface and Record implementations
sealed interface Payment permits CashPayment, CardPayment, UPIPayment {
    double amount(); // Common accessor for all payments
}

record CashPayment(double amount) implements Payment {
}

record CardPayment(String last4Digits, double amount) implements Payment {
}

record UPIPayment(String upiId, double amount) implements Payment {
}

// 2. Processing logic using Switch Pattern Matching
void processPayment(Payment p) {
    String message = switch (p) {
        case CashPayment cp -> "Handling cash transaction of $%.2f".formatted(cp.amount());
        case CardPayment card -> "Authorizing card ending in %s for $%.2f".formatted(card.last4Digits(), card.amount());
        case UPIPayment upi -> "Verifying UPI ID %s for $%.2f".formatted(upi.upiId(), upi.amount());
        // No default needed! The compiler knows these are the only 3 possibilities.
    };
    System.out.println("[PROCESS] " + message);
}

// 3. Receipt generation
String generateReceipt(Payment p) {
    return switch (p) {
        case CashPayment cp -> """
                RECEIPT: CASH
                Amount: $%.2f
                Status: PAID
                """.formatted(cp.amount());
        case CardPayment card -> """
                RECEIPT: CREDIT/DEBIT
                Card: **** **** **** %s
                Amount: $%.2f
                Status: AUTHORIZED
                """.formatted(card.last4Digits(), card.amount());
        case UPIPayment upi -> """
                RECEIPT: UPI
                ID: %s
                Amount: $%.2f
                Status: COMPLETED
                """.formatted(upi.upiId(), upi.amount());
    };
}

void main() {
    // 4. Create one of each payment type
    Payment[] payments = {
            new CashPayment(25.50),
            new CardPayment("4412", 150.00),
            new UPIPayment("user@okaxis", 12.99)
    };

    System.out.println("--- Payment Processing System ---");

    for (Payment p : payments) {
        processPayment(p);
        System.out.println(generateReceipt(p));
        System.out.println("---------------------------------");
    }
}