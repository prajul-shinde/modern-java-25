import main.java.week1.drills.Helper;

import static java.lang.IO.println;
import static java.lang.IO.readln;

void main() {
    String firstName = readln("Enter your first name: ");
    String lastName = readln("Enter your last name: ");
    println("Hello, %s %s! Welcome to Java".formatted(firstName, lastName));
    Helper.greet("%s %s".formatted(firstName, lastName));
}