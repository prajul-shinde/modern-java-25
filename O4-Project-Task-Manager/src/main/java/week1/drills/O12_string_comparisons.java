import static java.lang.IO.println;

void main() {

    String a = "test";
    String b = "test";
    String c = new String("test");
    println("a==b %s".formatted(a == b));  // true
    println("a==c %s".formatted(a == c));  // false
    println("a.equals(b) %s".formatted(a.equals(b))); // true
    println("a.equals(c) %s".formatted(a.equals(c))); // true
}