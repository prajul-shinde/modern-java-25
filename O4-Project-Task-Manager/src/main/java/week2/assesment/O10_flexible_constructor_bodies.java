import static java.lang.IO.println;

class Person {

    private final String fullName;

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}

class Employee extends Person {

    public Employee(String firstName, String lastName) {
        if (firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Names cannot be null or empty");
        }

        // 2. Transformation Logic (Trim and Uppercase)
        String cleanFirst = firstName.trim().toUpperCase();
        String cleanLast = lastName.trim().toUpperCase();
        String formattedName = cleanFirst + " " + cleanLast;

        // 3. Call the parent constructor with the processed data
        super(formattedName);
        println("Employee created for: %s".formatted(formattedName));
    }
}

void main() {
    var emp = new Employee("  john  ", "doe  ");
    println("Final Full Name: " + emp.getFullName());
}