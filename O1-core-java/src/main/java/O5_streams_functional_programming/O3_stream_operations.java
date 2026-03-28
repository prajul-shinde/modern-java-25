import static java.lang.IO.println;

void main() {

    List<Student> students = List.of(
            new Student("Alice", 98, "Math"),
            new Student("Bob", 74, "Science"),
            new Student("Charlie", 92, "Math"),
            new Student("Diana", 61, "English"),
            new Student("Eve", 88, "Science"),
            new Student("Frank", 77, "English"),
            new Student("George", 55, "Math"),
            new Student("Hank", 68, "Science")
    );

    double average = students.stream().mapToInt(Student::grade).average().orElse(0);
    println("Average grade %.2f ".formatted(average));

    long aboveAvg = students.stream().filter(s -> s.grade() > average).count();
    println("Students above average of %.2f : %d ".formatted(average, aboveAvg));

    List<Student> top3 = students.stream().sorted(Comparator.comparingInt(Student::grade).reversed()).limit(3).toList();
    println("Top 3 students: ");
    top3.forEach(s -> {
        println(" %-10s - %d%n".formatted(s.name(), s.grade()));
    });

    Map<String, List<String>> groupByGrade = students.stream().collect(Collectors.groupingBy(
            s -> s.grade() >= 90 ? "A" : s.grade() >= 75 ? "B" : "c",
            Collectors.mapping(Student::name, Collectors.toList())
    ));
    System.out.println("\nGrade distribution:");
    new TreeMap<>(groupByGrade).forEach((grade, names) ->
            println("  " + grade + ": " + names));
}

record Student(String name, int grade, String subject) {
}