import static java.lang.IO.println;

void main() {
    // Collections
    List<String> names = new ArrayList<>();
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");

    // Map
    Map<String, Integer> ages = new HashMap<>();
    ages.put("Alice", 25);
    ages.put("Bob", 30);
    ages.put("Charlie", 28);

    // Math
    double pi = Math.PI;
    double sqrt = Math.sqrt(16);

    // Date/Time (preview for Week 4)
    var now = java.time.LocalDateTime.now();

    // Formatting output
    String output = """
            
            Module Import Demo
            ==================
            Names: %s
            Ages: %s
            
            Math Constants:
            - Pi: %.5f
            - sqrt(16): %.1f
            
            Current Time: %s
            """.formatted(names, ages, pi, sqrt, now);

    println(output);
}