import static java.lang.IO.println;

void main() {

    List<Product> products = List.of(
            new Product("Gaming Laptop", "Electronics", 1299.99, 15),
            new Product("Wireless Mouse", "Electronics", 39.99, 8),
            new Product("USB Cable", "Electronics", 9.99, 2),
            new Product("Mechanical KB", "Electronics", 89.99, 20),
            new Product("Leather Jacket", "Clothing", 129.99, 30),
            new Product("Running Shoes", "Clothing", 79.99, 25),
            new Product("Silk Scarf", "Clothing", 49.99, 7),
            new Product("Denim Jeans", "Clothing", 59.99, 40),
            new Product("Organic Honey", "Food", 24.99, 5),
            new Product("Olive Oil", "Food", 18.99, 50),
            new Product("Granola Bars", "Food", 12.99, 60)
    );

    // 1. Most expensive per category
    println("=== Most Expensive Per Category ===");
    products.stream().collect(
                    Collectors.groupingBy(Product::category,
                            Collectors.maxBy(Comparator.comparingDouble(Product::price))))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(e -> e.getValue().ifPresent(p ->
                    System.out.printf("  %-12s: %-20s - $%.2f%n",
                            p.category(), p.name(), p.price())));

    // 2. Total inventory value
    double totalValue = products.stream().mapToDouble(p -> p.price() * p.quantity()).sum();
    println("%n=== Total Inventory Value ===%n  $%,.2f%n".formatted(totalValue));

    // 3. Products needing restock
    products.stream().filter(p -> p.quantity() < 10)
            .sorted(Comparator.comparingInt(Product::quantity))
            .forEach(p ->
                    println("  %-20s: %d units%n".formatted(p.name(), p.quantity()))
            );

    // 4. 20% discount on Electronics
    products.stream().filter(p -> "Electronics".equals(p.category()))
            .map(p -> new Product(p.name(), p.category(), p.price() * 0.8, p.quantity()))
            .forEach(p -> println("  %-20s: $%,.2f%n".formatted(p.name(), p.price())));


}

record Product(String name, String category, double price, int quantity) {
}