void main() {

    String item1 = "Coffee", item2 = "Notebook", item3 = "Pen", item4 = "USB Cable", item5 = "Mouse Pad";
    int qty1 = 2, qty2 = 1, qty3 = 3, qty4 = 1, qty5 = 2;
    double price1 = 7.00, price2 = 4.50, price3 = 2.25, price4 = 12.99, price5 = 17.98;

    double subtotal = price1 + price2 + price3 + price4 + price5;
    double tax = subtotal * 0.08;
    double total = subtotal + tax;

    String receipt = """
            ╔══════════════════════════════════╗
            ║          JAVA STORE              ║
            ╠══════════════════════════════════╣
            ║ %-15s x%-4d $%5.2f       ║
            ║ %-15s x%-4d $%5.2f       ║
            ║ %-15s x%-4d $%5.2f       ║
            ║ %-15s x%-4d $%5.2f       ║
            ║ %-15s x%-4d $%5.2f       ║
            ╠══════════════════════════════════╣
            ║ Subtotal:             $%5.2f       ║
            ║ Tax (8%%):             $%5.2f       ║
            ║ TOTAL:                $%5.2f       ║
            ╚══════════════════════════════════╝
            """.formatted(
            item1, qty1, price1,
            item2, qty2, price2,
            item3, qty3, price3,
            item4, qty4, price4,
            item5, qty5, price5,
            subtotal, tax, total
    );
    System.out.println(receipt);
}