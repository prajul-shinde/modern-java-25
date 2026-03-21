import static java.lang.IO.println;

void main() {
    String text = "Java is a great language. Java is used for building "
            + "enterprise applications. The Java collections framework is "
            + "a key part of Java. Java provides a rich set of collections "
            + "including List Set and Map. The Map interface is very useful.";

    Map<String, Integer> frequency = new HashMap<>();
    for (String word : text.split("\\s+")) {
        String clean = word.toLowerCase().replaceAll("[^a-z]", "");
        if (!clean.isEmpty())
            frequency.merge(clean, 1, Integer::sum);
    }

    int totalWords = frequency.values().stream().mapToInt(Integer::intValue).sum();
    println("Word Frequency Analysis");
    println("=".repeat(23));
    println("Total words: " + totalWords);
    println("Unique words: " + frequency.size());

    println("\nTop 5 most frequent:");
    frequency.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(5)
            .forEach(e -> System.out.printf("  %-10s → %d%n", e.getKey(), e.getValue()));

    List<String> wordsAppearingOnce = frequency.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).sorted().toList();
    println("\nWords appearing once: " + wordsAppearingOnce);

}