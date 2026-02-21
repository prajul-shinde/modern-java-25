import static java.lang.IO.println;

void main() {

    List<Message> messages = List.of(
            new TextMessage("Alice", "Hello!", System.currentTimeMillis()),
            new ImageMessage("Bob", "http://example.com/pic.jpg", 1920, 1080),
            new VideoMessage("Charlie", "http://example.com/vid.mp4", 120)
    );

    messages.forEach(message -> {
        processMessage(message);
        println("-------------");
    });
}

void processMessage(Message message) {

    switch (message) {
        case TextMessage(String sender, String content, long timestamp) -> {
            println("Text from %s : %s".formatted(sender, content));
            println("sent at: %d".formatted(timestamp));
        }
        case ImageMessage(String sender, String url, int width, int height) -> {
            println("Image from: %s".formatted(sender));
            println("Dimenstions: %dx%d".formatted(width, height));
            println("Url: ".formatted(url));
        }
        case VideoMessage(String sender, String url, int durationInSeconds) -> {
            println("Video from %s".formatted(sender));
            println("Duration: %d seconds".formatted(durationInSeconds));
            println("URL: " + url);
        }
    }
}

sealed interface Message permits TextMessage, ImageMessage, VideoMessage {
}

record VideoMessage(String sender, String url, int durationInSeconds) implements Message {
}

record ImageMessage(String sender, String url, int width, int height) implements Message {
}

record TextMessage(String sender, String content, long timestamp) implements Message {
}