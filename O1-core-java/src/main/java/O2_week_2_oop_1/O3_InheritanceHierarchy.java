import static java.lang.IO.print;
import static java.lang.IO.println;

abstract class Employee {
    protected String name;
    protected int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();

    void displayInfo() {
        String info = """
                "Id" : %d
                "Name" : %s
                "Salary" : $%.2f
                """.formatted(id, name, calculateSalary());
        print(info);
    }
}

class SalariedEmployee extends Employee {

    private double annualSalary;

    SalariedEmployee(String name, int id, double annualSalary) {
        if (annualSalary < 0)
            throw new IllegalArgumentException("annual salary cannot be zero");
        super(name, id);
        this.annualSalary = annualSalary;
    }

    @Override
    double calculateSalary() {
        return annualSalary / 12;
    }
}

void main() {

    List<Employee> employees = List.of(
            new SalariedEmployee("Jane", 1, 60000),
            new SalariedEmployee("John", 2, 120000)

    );

    for (Employee emp : employees) {
        emp.displayInfo();
        println("===================");
    }

    // Calculate total payroll
    double total = employees.stream()
            .mapToDouble(Employee::calculateSalary)
            .sum();

    println("Total Monthly Payroll: $%.2f".formatted(total));
}
