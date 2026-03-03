import static java.lang.IO.println;

void main() {

    List<PaymentGateway> gateways = List.of(
            new CreditCardGateway("1234567812345678", "123"),
            new UPIGateway("user@upi")
    );
    gateways.forEach(gateway -> gateway.initiatePayment(100.00));
}

abstract class PaymentGateway {
    String gatewayName;

    public PaymentGateway(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    abstract boolean processPayment(double amount);

    abstract void validateDetails();

    void initiatePayment(double amount) {
        try {
            validateDetails();
            boolean success = processPayment(amount);
            if (success)
                println("Payment Successful via %s!".formatted(gatewayName));
        } catch (IllegalArgumentException e) {
            println("payment failed: " + e.getMessage());
        }
    }
}

class CreditCardGateway extends PaymentGateway {
    String cardNumber;
    String cvv;

    public CreditCardGateway(String cardNumber, String cvv) {
        super("CreditCard");
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    boolean processPayment(double amount) {
        println("Processing credit card payment of $%.2f...".formatted(amount));
        return true;
    }

    @Override
    void validateDetails() {
        if (cardNumber == null || !cardNumber.matches("\\d{16}"))
            throw new IllegalArgumentException("Card number must be 16 digits");
        if (cvv == null || !cvv.matches("\\d{3}"))
            throw new IllegalArgumentException("Cvv must be 3 digits");
    }
}

class UPIGateway extends PaymentGateway {
    String upiId;

    public UPIGateway(String upiId) {
        super("UPI");
        this.upiId = upiId;
    }

    @Override
    boolean processPayment(double amount) {
        println("Processing UPI payment of $%.2f...".formatted(amount));
        return true;
    }

    @Override
    void validateDetails() {
        if (upiId == null || !upiId.contains("@"))
            throw new IllegalArgumentException("Invalid UPI Id");
    }
}