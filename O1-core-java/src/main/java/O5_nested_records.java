import static java.lang.IO.println;

record Address(String street, String city, String state, String zip) {

    Address {
        if (street == null || city == null || state == null || zip == null)
            throw new IllegalArgumentException("All address fields required");
    }

    @Override
    public String toString() {
        return "%s, %s, %s, %s".formatted(street, city, state, zip);
    }
}

record Customer(String name, String email, Address address) {

    Customer {
        if (name == null || email == null || address == null)
            throw new IllegalArgumentException("all fields are required");
    }
}

record Product(String id, String name, double price) {

    Product {
        if (price <= 0)
            throw new IllegalArgumentException("price must be greater than zero");
    }
}

record OrderItem(Product product, int quantity) {
    OrderItem {
        if (quantity <= 0)
            throw new IllegalArgumentException("quantity must be greater than 0");
    }

    double totalPrice() {
        return product.price * quantity;
    }
}

record Order(String orderId, Customer customer, List<OrderItem> items) {
    Order {
        if (orderId == null || customer == null || items.isEmpty())
            throw new IllegalArgumentException("All parameters are required");
        items = List.copyOf(items);
    }

    double subTotal() {
        return items.stream().mapToDouble(OrderItem::totalPrice).sum();
    }

    double tax() {
        return subTotal() * 0.8;
    }

    double total() {
        return subTotal() + tax();
    }

    void printReceipt() {
        println("=".repeat(50));
        println("Order #" + orderId);
        println("=".repeat(50));
        println();
        println("Customer: " + customer.name());
        println("Email: " + customer.email());
        println("Address: " + customer.address());
        println();
        println("Items:");
        println("-".repeat(50));
        for (var item : items) {
            println("%-30s %2d x %6.2f = $%8.2f".formatted(
                    item.product().name(),
                    item.quantity(),
                    item.product().price(),
                    item.totalPrice()
            ));
        }
        println("-".repeat(50));
        println("Subtotal:  %35s $%8.2f".formatted("", subTotal()));
        println("Tax (8%%): %35s $%8.2f".formatted("", tax()));
        println("=".repeat(50));
        println("TOTAL: %38s $%8.2f".formatted("", total()));
        println("=".repeat(50));
    }
}

void main() {
    Address addr = new Address("123 Main St", "Springfield", "IL", "62701");
    Customer customer = new Customer("John Doe", "john@example.com", addr);

    List<OrderItem> items = List.of(
            new OrderItem(new Product("P001", "Laptop", 999.99), 1),
            new OrderItem(new Product("P002", "Mouse", 25.50), 2),
            new OrderItem(new Product("P003", "Keyboard", 75.00), 1)
    );

    Order order = new Order("ORD-2024-001", customer, items);
    order.printReceipt();
}