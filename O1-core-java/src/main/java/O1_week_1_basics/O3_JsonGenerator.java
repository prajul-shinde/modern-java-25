import static java.lang.IO.print;
import static java.lang.IO.println;

record User(String username, String fullName, int age) {
}

void main() {

    var users = List.of(
            new User("john_doe", "John doe", 30),
            new User("jane_smith", "Jane smith", 30)
    );

    println("{");
    println("\"users\": [");
    for (var i = 0; i < users.size(); i++) {
        var user = users.get(i);
        var comma = i < users.size() - 1 ? "," : "";
        var userJson = """
                    {
                      "username": "%s",
                      "fullName": "%s",
                      "age" : %d
                    }%s
                """.formatted(user.username, user.fullName, user.age, comma);
        print(userJson);
    }
    println("  ]");
    println("}");
}