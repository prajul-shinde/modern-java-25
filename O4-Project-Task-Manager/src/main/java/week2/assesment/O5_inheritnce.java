import static java.lang.IO.println;

void main() {

    Employee[] staff = {
            new Manager("Alice", 5000, 1200),
            new Developer("Bob", 50, 160),
            new Manager("Charlie", 4500, 800)
    };

    System.out.println("--- Monthly Payroll ---");
    for (Employee e : staff) {
        println("Employee: %s | Pay: $%.2f%n".formatted(
                e.getName(), e.calculatePay()));
    }
}

abstract class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract double calculatePay();
}

class Manager extends Employee {

    private final double baseSalary;
    private final double bonus;

    Manager(String name, double baseSalary, double bonus) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    double calculatePay() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {

    private final double hourlyRate;
    private final int hoursWorked;

    Developer(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}