import static java.lang.IO.println;

void main() {

    EmailService email = new EmailService("smtp.example.com");
    SMSService sms = new SMSService("API_KEY_123");
    PushNotificationService push = new PushNotificationService("APP_001");

    email.sendWithLog("alice@example.com", "Hello Alice");
    sms.sendBulk(List.of("+1111111111", "+2222222222"), "Hello!");
    push.scheduleNotification("device123", "Reminder!", 30);
}

interface NotificationService {

    void sendNotification(String recipient, String message);

    default void sendBulk(List<String> recipients, String message) {

        recipients.forEach(r -> sendNotification(r, message));
    }

    default void sendWithLog(String recipient, String message) {
        sendNotification(recipient, message);
        println("message sent to %s. message: %s".formatted(recipient, message));
    }

    private String formatMessage(String message) {
        return "[ " + LocalDateTime.now().withNano(0) + "]" + message;
    }

}

interface Schedulable {
    default void scheduleNotification(String recipient, String message, int delaySeconds) {
        println("[Scheduled to] %s in %ds-> %s ".formatted(recipient, delaySeconds, message));
    }
}

class EmailService implements NotificationService {
    private String smtpServer;

    EmailService(String smtpServer) {
        this.smtpServer = smtpServer;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[Email via " + smtpServer + "] To: " +
                recipient + " → " + message);
    }
}

class SMSService implements NotificationService {
    private String apiKey;

    SMSService(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[SMS] To: " + recipient + " → " + message);
    }
}

class PushNotificationService implements NotificationService, Schedulable {
    private String appId;

    PushNotificationService(String appId) {
        this.appId = appId;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[Push:" + appId + "] To: " + recipient + " → " + message);
    }
}