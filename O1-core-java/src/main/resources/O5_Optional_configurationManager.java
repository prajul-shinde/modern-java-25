void main() {
    ConfigManager config = new ConfigManager();

    System.out.printf("%-12s (%-7s): %s%n", "host", "String",
            config.getStringOrDefault("host", "127.0.0.1"));
    System.out.printf("%-12s (%-7s): %s%n", "port", "Integer",
            config.getIntOrDefault("port", 80));
    System.out.printf("%-12s (%-7s): %s%n", "timeout", "Integer",
            config.getIntOrDefault("timeout", 60));
    System.out.printf("%-12s (%-7s): %s%n", "debug", "Boolean",
            config.getBoolean("debug").orElse(false));
    System.out.printf("%-12s (%-7s): %s  ← default used%n", "maxConnections", "Integer",
            config.getIntOrDefault("maxConnections", 100));

}

class ConfigManager {

    private Map<String, String> configs = new HashMap<>();

    ConfigManager() {
        configs.put("host", "localhost");
        configs.put("port", "8080");
        configs.put("timeout", "30");
        configs.put("debug", "true");
    }

    Optional<String> getString(String key) {
        return Optional.ofNullable(configs.get(key));
    }

    Optional<Integer> getInt(String key) {
        return getString(key).map(Integer::parseInt);
    }

    Optional<Boolean> getBoolean(String key) {
        return getString(key).map(Boolean::parseBoolean);
    }

    String getStringOrDefault(String key, String defaultValue) {
        return getString(key).orElse(defaultValue);
    }

    int getIntOrDefault(String key, int defaultVal) {
        return getInt(key).orElse(defaultVal);
    }
}