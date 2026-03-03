void main() {
    Map<String, Object> json = new LinkedHashMap<>();
    json.put("name", "Alice");
    json.put("age", 30);
    json.put("score", 95.50);
    json.put("active", true);
    json.put("nickname", "");
    json.put("debt", -500);
    json.put("balance", 0);
    json.put("extra", null);

    parseObject(json);
}

String formatValue(Object value) {

    return switch (value) {
        case null -> "null";
        case String s when s.isEmpty() -> "\"\" (empty string)";
        case String s -> "\"" + s + "\"";
        case Integer i when i < 0 -> i + " (negative)";
        case Integer i when i == 0 -> "0 (zero)";
        case Integer i -> String.valueOf(i);
        case Double d -> "%.2f".formatted(d);
        case Boolean b -> String.valueOf(b);
        default -> "unknown";
    };
}

void parseObject(Map<String, Object> jsonMap) {
    for (var entry : jsonMap.entrySet()) {
        System.out.println(entry.getKey() + ": " + formatValue(entry.getValue()));
    }
}