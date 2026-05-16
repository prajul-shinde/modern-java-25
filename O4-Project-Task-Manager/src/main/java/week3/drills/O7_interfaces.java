import static java.lang.IO.println;

void main() {

    Logger logger = new ConsoleLogger();

    logger.logInfo("Application initialized successfully.");
    logger.logWarning("Deprecated API usage detected.");
    logger.logError("NullPointerException encountered at line 42.");
    logger.log("Application crashed!");
}

class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        println(message);
    }
}

interface Logger {

    void log(String message);

    default void logInfo(String message) {
        log(formatMessage("INFO", message));
    }

    default void logWarning(String message) {
        log(formatMessage("WARNING", message));
    }

    default void logError(String message) {
        log(formatMessage("ERROR", message));
    }

    private String formatMessage(String level, String message) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[%s] [%s] %s".formatted(timeStamp, level, message);
    }
}