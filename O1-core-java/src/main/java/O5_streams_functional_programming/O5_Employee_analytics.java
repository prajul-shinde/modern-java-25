import static java.lang.IO.println;

void main() {

    List<Employee> employees = List.of(
            new Employee("Alice", "Engineering", 95000, 30),
            new Employee("Bob", "Marketing", 65000, 28),
            new Employee("Charlie", "Engineering", 90000, 35),
            new Employee("Diana", "Sales", 70000, 27),
            new Employee("Eve", "Engineering", 80000, 32),
            new Employee("Frank", "Marketing", 70000, 40),
            new Employee("George", "Sales", 68000, 29),
            new Employee("Hank", "HR", 62000, 45),
            new Employee("Iris", "Sales", 77000, 33)
    );

    // 1. Group by department → names
    println("=== Employees By Department ===");
    Map<String, List<String>> byDept = employees.stream().collect(
            Collectors.groupingBy(
                    Employee::department,
                    Collectors.mapping(Employee::name, Collectors.toList())
            )
    );

    new TreeMap<>(byDept)
            .forEach((dept, names) ->
                    println("  %-12s: %s%n".formatted(dept, names)));

    // 2. Average salary per department
    println("\n=== Average Salary Per Department ===");
    Map<String, Double> avgSalary = employees.stream()
            .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.averagingDouble(Employee::salary)
            ));
    new TreeMap<>(avgSalary)
            .forEach((dept, avg) ->
                    println("  %-12s: $%,.2f%n".formatted(dept, avg)));
    // 3. Department with the highest avg salary
    println("\n=== Highest-Paid Department ===");
    avgSalary.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .ifPresent(e ->
                    println("  %s with avg salary $%,.2f%n".formatted(e.getKey(), e.getValue())));

    // 4. Count per department
    println("\n=== Employee Count ===");
    Map<String, Long> employeesPerDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));

    new TreeMap<>(employeesPerDept)
            .forEach((dept, count) ->
                    println("  %-12s: %d%n".formatted(dept, count)));

    // Bonus: partition by salary > 75k
    println("\n=== Salary Partition ===");
    Map<Boolean, Long> partition = employees.stream()
            .collect(Collectors.partitioningBy
                    (e -> e.salary() > 75000, Collectors.counting()));

    println("  Above $75k : " + partition.get(true) + " employees");
    println("  Up to $75k : " + partition.get(false) + " employees");
}


record Employee(String name, String department, double salary, int age) {
}