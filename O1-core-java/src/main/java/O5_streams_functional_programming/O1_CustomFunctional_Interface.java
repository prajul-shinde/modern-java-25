import static java.lang.IO.println;

void main() {

    StringValidator notBlank = s -> s != null && !s.isBlank();
    StringValidator minLength = s -> s != null && s.length() >= 5;
    StringValidator hasAt = s -> s != null && s.contains("@");
    StringValidator allChecks = notBlank.and(minLength).and(hasAt);

    println("=== StringValidator ===");
    String email = "hello@test.com";
    println("\"" + email + "\" not-blank:  " + notBlank.validate(email));
    println("\"" + email + "\" minLength:  " + minLength.validate(email));
    println("\"" + email + "\" hasAt:      " + hasAt.validate(email));
    println("\"" + email + "\" all combined: " + allChecks.validate(email));
    println("\"hi\" all combined: " + allChecks.validate("hi"));

    NumberFormatter currency = n -> String.format("$%,.2f", n);
    NumberFormatter percentage = n -> String.format("%.2f%%", n * 100);
    NumberFormatter scientific = n -> String.format("%e", n);

    println("\n=== NumberFormatter ===");
    double num = 1234.567;
    println("Currency:    " + currency.format(num));
    println("Percentage:  " + percentage.format(num));
    println("Scientific:  " + scientific.format(num));

    ListProcessor<Integer, Integer> sum = list -> list.stream().mapToInt(Integer::intValue).sum();
    
}

@FunctionalInterface
interface StringValidator {

    boolean validate(String input);

    default StringValidator and(StringValidator other) {
        return input -> this.validate(input) && other.validate(input);
    }
}

@FunctionalInterface
interface NumberFormatter {
    String format(double number);

}

@FunctionalInterface
interface ListProcessor<T, R> {

    R process(List<T> list);
}