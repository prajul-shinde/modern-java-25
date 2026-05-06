void main() {

    ServerConfig dev = ServerConfig.development();
    ServerConfig prod = ServerConfig.production();

    // Display results
    System.out.println("Development URL: " + dev.connectionUrl());
    // Output: http://localhost:8080

    System.out.println("Production URL: " + prod.connectionUrl());
    // Output: https://api.production.com:443

    // You can still create custom configs if needed
    ServerConfig staging = new ServerConfig("staging.server.io", 9000, true);
    System.out.println("Staging URL: " + staging.connectionUrl());
}

public record ServerConfig(String host, int port, boolean ssl) {

    static ServerConfig development() {
        return new ServerConfig("localhost", 8080, false);
    }

    static ServerConfig production() {
        return new ServerConfig("api.production.com", 8080, true);
    }

    String connectionUrl() {
        var protocol = ssl ? "Https" : "Http";
        return "%s://%s:%d".formatted(protocol, host, port);
    }
}