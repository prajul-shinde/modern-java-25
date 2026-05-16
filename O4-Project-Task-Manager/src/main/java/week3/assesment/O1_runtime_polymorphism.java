interface Notifiable {
    // Abstract methods
    void send(String message);

    String getType();

    // Default method demonstrating shared logic relying on an abstract method
    default void log(String message) {
        System.out.println("[" + getType() + "] Sending: " + message);
    }
}

// 2. Three Implementations [6 Marks]

class EmailNotification implements Notifiable {
    @Override
    public void send(String message) {
        log(message); // Utilizing the default method
        System.out.println("   -> Connecting to SMTP server...");
        System.out.println("   -> Email delivered.\n");
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}

class SMSNotification implements Notifiable {
    @Override
    public void send(String message) {
        log(message); // Utilizing the default method
        System.out.println("   -> Pinging telecom carrier...");
        System.out.println("   -> SMS text sent.\n");
    }

    @Override
    public String getType() {
        return "SMS";
    }
}

class PushNotification implements Notifiable {
    @Override
    public void send(String message) {
        log(message); // Utilizing the default method
        System.out.println("   -> Routing via APNS/Firebase...");
        System.out.println("   -> Push notification displayed on device.\n");
    }

    @Override
    public String getType() {
        return "PUSH";
    }
}


// 3. notifyAll method using polymorphism [4 Marks]
public void notifyAll(List<Notifiable> channels, String message) {
    for (Notifiable channel : channels) {
        // Polymorphism: Java dynamically determines WHICH send() method to execute
        // based on the actual object type at runtime.
        channel.send(message);
    }
}

// 4. Main tests correctly [2 Marks]
void main() {
    // Storing all 3 implementations in a List of the Interface type
    List<Notifiable> notificationChannels = List.of(
            new EmailNotification(),
            new SMSNotification(),
            new PushNotification()
    );

    System.out.println("=== Initiating System Broadcast ===\n");

    // Calling notifyAll with the list
    notifyAll(notificationChannels, "Server maintenance scheduled for 2:00 AM.");

    System.out.println("=== Broadcast Complete ===");
}
