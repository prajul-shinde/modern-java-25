import static java.lang.IO.println;
import static java.lang.IO.readln;

//Write a program that:

//        - Uses modern `void main()`

//        - Asks for first name, last name, and age

//- Prints a formatted welcome message using a text block with `.formatted()`

//        - Output must look like:
//        ```
//        ┌────────────────────────────┐
//        │  Welcome, Rohan Sharma!    │
//        │  Age: 22                   │
//        │  Java Mastery starts now.  │
//        └────────────────────────────┘
//        ```
void main() {
    String firstName = readln("Enter your firstName: ");
    String lastName = readln("Enter your lastName: ");
    int age = Integer.parseInt(readln("Enter your age: "));

    var result = """
            __________________________
            | Welcome, %s %s!         |
            | Age: %d                 |
            | Java Mastery starts now |
            |_________________________|
            """.formatted(firstName, lastName, age);
    println(result);

}