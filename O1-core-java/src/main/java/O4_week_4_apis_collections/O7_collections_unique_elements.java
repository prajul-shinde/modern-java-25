import static java.lang.IO.println;

void main() {
    List<String> original = new ArrayList<>(Arrays.asList(
            "banana", "apple", "cherry", "apple", "banana",
            "date", "cherry", "fig", "apple", "date"
    ));

    LinkedHashSet<String> uniqueOrdered = new LinkedHashSet<>(original);
    TreeSet<String> uniqueSorted = new TreeSet<>(original);
    println("Original (" + original.size() + " items): " + original);
    println("Unique (insertion order, " + uniqueOrdered.size() + " items): " + uniqueOrdered);
    println("Unique (sorted, " + uniqueSorted.size() + " items):          " + uniqueSorted);
    println("Duplicates removed: " + (original.size() - uniqueOrdered.size()));
    println("\n repeaed elements: ");
    Map<String, Integer> freq = new HashMap<>();
    for (String item : original) freq.merge(item, 1, Integer::sum);
    freq.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(e -> System.out.printf("  %-10s → %d times%n", e.getKey(), e.getValue()));

}