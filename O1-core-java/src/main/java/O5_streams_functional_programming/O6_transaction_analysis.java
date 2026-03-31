import static java.lang.IO.println;

void main() {

    List<Transaction> transactions = List.of(
            new Transaction("T01", "Alice", 500.00, "DEBIT"),
            new Transaction("T02", "Bob", 200.00, "CREDIT"),
            new Transaction("T03", "Alice", 925.00, "DEBIT"),
            new Transaction("T04", "Charlie", 300.00, "DEBIT"),
            new Transaction("T05", "Bob", 980.00, "DEBIT"),
            new Transaction("T06", "Diana", 150.00, "CREDIT"),
            new Transaction("T07", "Alice", 10.00, "CREDIT"),  // small
            new Transaction("T08", "Charlie", 590.00, "DEBIT"),
            new Transaction("T09", "Bob", 10.00, "CREDIT"),  // small
            new Transaction("T10", "Diana", 280.00, "DEBIT"),
            new Transaction("T11", "Charlie", 90.00, "CREDIT"),  // <- note: under 1000 total for Charlie? adjust if needed
            new Transaction("T12", "Bob", 2000.00, "DEBIT")    // large
    );

    // 1. total amount per user sorted desc
    println("=== Total Per User ===");
    Map<String, Double> totalByUser = transactions.stream()
            .collect(Collectors.groupingBy(
                    Transaction::user,
                    Collectors.summingDouble(Transaction::amount)
            ));
    totalByUser.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(e ->
                    println("  %-8s: $%,.2f%n".formatted(e.getKey(), e.getValue())));

    // 2. Users with total > $1000
    println("\n=== Users With Total > $1000 ===");

    List<String> bigSpenders = totalByUser.entrySet()
            .stream()
            .filter(e -> e.getValue() > 1000)
            .map(Map.Entry::getKey)
            .sorted()
            .toList();
    println("BigSpenders:  " + bigSpenders);

    // 3. Average transaction amount
    println("\n=== Average Transaction Amount ===");
    OptionalDouble average = transactions
            .stream()
            .mapToDouble(Transaction::amount)
            .average();
    average.ifPresent(a -> println("  $%,.2f%n".formatted(average)));

    // 4. Top 5 spenders
    println("\n=== Top 5 Spenders ===");
    List<Map.Entry<String, Double>> top5 = totalByUser
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(5)
            .toList();
    for (int i = 0; i < top5.size(); i++) {
        println("  #%d  %-8s- $%,.2f%n".formatted(
                i + 1, top5.get(i).getKey(), top5.get(i).getValue()));
    }

}

record Transaction(String id, String user, double amount, String type) {
}