import static java.lang.IO.println;

void main() {

    println("=== Running CSV Export ===");
    DataExporter csvExporter = new CSVExporter();
    csvExporter.export(); // Invokes the template method

    println("\n=== Running JSON Export ===");
    DataExporter jsonExporter = new JSONExporter();
    jsonExporter.export(); // Invokes the same template method
}

abstract class DataExporter {

    abstract List<String> fetchData();

    abstract String format(List<String> data);

    final void export() {
        List<String> data = fetchData();
        String result = format(data);
        println("exporting result: %s".formatted(result));
    }
}

class CSVExporter extends DataExporter {
    @Override
    List<String> fetchData() {
        // Simulating data retrieval
        return List.of("ID,Name,Role", "1,Alice,Dev", "2,Bob,Designer");
    }

    @Override
    String format(List<String> data) {
        // Data is already raw rows, join with newlines
        return String.join("\n", data);
    }
}

// Implementation 2: JSON Exporter
class JSONExporter extends DataExporter {
    @Override
    List<String> fetchData() {
        return List.of("Alice", "Bob");
    }

    @Override
    String format(List<String> data) {
        // 1. Use IntStream to handle the index generation safely
        return IntStream.range(0, data.size())
                .mapToObj(i -> """
                        { "id": %d, "name": "%s" }""".formatted(i + 1, data.get(i)))
                // 2. Automatically join objects with a comma and newline delimiter
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
    }
}