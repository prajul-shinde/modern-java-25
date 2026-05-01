import static java.lang.IO.println;


static void main() {
    String s = "hello";
    String upperCase = s.toUpperCase();
    println("immutable that's why s stays same in lowercase: s = %s".formatted(s));
    println("when we say s.toUpperCase it created new Object");
}

