import static java.lang.IO.println;

void main() {

    var service = new UserService();

    println("findById(1): " + service.findById(1));
    println("findById(99): " + service.findById(99));

    service.getEmailById(1).ifPresentOrElse(e -> println("Email for id= 1: " + e), () -> println("Email for id=1: not found"));

    service.findAdult(2).ifPresentOrElse(u -> println("id=2 is an adult"), () -> println("adult check for id=2 (age=16): not an adult"));
    println("getNameOrDefault(99): " + service.getNameOrDefault(99));

    println("getOrThrow(1): " + service.getOrThrow(1));
    try {
        service.getOrThrow(99);
    } catch (IllegalArgumentException e) {
        println("getOrThrow(99): Exception: " + e.getMessage());
    }

}

record User(int id, String name, String email, int age) {
}

class UserService {

    private List<User> users = List.of(
            new User(1, "Alice", "alice@example.com", 25),
            new User(2, "Bob", "bob@example.com", 16),
            new User(3, "Charlie", "charlie@example.com", 30),
            new User(4, "Diana", "diana@example.com", 20)
    );

    Optional<User> findById(int id) {
        return users.stream().filter(u -> u.id() == id).findFirst();
    }

    Optional<String> getEmailById(int id) {
        return findById(id).map(User::email);
    }

    Optional<User> findAdult(int id) {
        return findById(id).filter(u -> u.age() >= 18);
    }

    String getNameOrDefault(int id) {
        return findById(id).map(User::name).orElse("Unknown User");
    }

    User getOrThrow(int id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("user not found for id: %d".formatted(id)));
    }
}