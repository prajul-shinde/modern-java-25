void main() {

    Payment[] payments = {
            new CreditCardPayment(),
            new PayPalPayment(),
            new CryptoPayment(),
    };

    System.out.println("--- Executing Polymorphic Calls ---");
    for (Payment p : payments) {
        // The reference type is 'Payment', but the behavior is specific
        p.process();
    }
}

abstract class Payment {

    abstract void process();
}

class CreditCardPayment extends Payment {
    @Override
    public void process() {
        System.out.println("Validating CVV and charging Credit Card...");
    }
}

// Subclass 2
class PayPalPayment extends Payment {
    @Override
    public void process() {
        System.out.println("Redirecting to PayPal login and authorizing...");
    }
}

// Subclass 3
class CryptoPayment extends Payment {
    @Override
    public void process() {
        System.out.println("Verifying wallet address and blockchain transaction...");
    }
}