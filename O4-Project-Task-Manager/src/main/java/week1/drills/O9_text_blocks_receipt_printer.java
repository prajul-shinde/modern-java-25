import static java.lang.IO.println;

static void main() {

    var name = "mobile phone";
    int quantity = 2;
    double price = 199.00;
    printReceipt(name, quantity, price);
}

private static void printReceipt(String name, int quantity, double price) {
    double subTotal = price * quantity;
    double taxAmount = subTotal * 0.08;
    double total = subTotal + taxAmount;
    var receipt = """
            %-12s: %10s
            %-12s: %10d
            %-12s: %10.2f
            -------------------------
            %-12s: %10.2f
            %-12s: %10.2f
            %-12s: %10.2f
            """.formatted("Item", name, "Quantity", quantity, "Unit Price", price, "Subtotal", subTotal, "Tax (8%)", taxAmount, "TOTAL", total);
    println(receipt);
}

