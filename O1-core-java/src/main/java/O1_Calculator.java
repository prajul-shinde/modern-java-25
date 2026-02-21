import static java.lang.IO.println;
import static java.lang.IO.readln;

void main() {

    println("===Simple Calculator===");
    var num1 = Double.parseDouble(readln("Enter first number: "));
    var num2 = Double.parseDouble(readln("Enter second number: "));
    String operator = readln("Enter operator(+,-,*,/): ");

    double result = 0.0;
    boolean isValidOp = true;

    switch (operator) {
        case "+" -> result = num1 + num2;
        case "-" -> result = num1 - num2;
        case "*" -> result = num1 * num2;
        case "/" -> {
            if (num2 == 0) {
                isValidOp = false;
                println("Error: Division by 0.");
            }
            result = num1 / num2;
        }
        default -> {
            println("Invalid operator.");
            isValidOp = false;
        }
    }

    if (isValidOp)
        println("Result: %.2f %s %.2f = %.2f".formatted(num1, operator, num2, result));
}