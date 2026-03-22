import static java.lang.IO.println;

void main() {

    Set<Student> set = new TreeSet<>(Set.of(
            new Student("Charlie", 3),
            new Student("Alice", 1),
            new Student("Eve", 5),
            new Student("Bob", 2),
            new Student("Diana", 4)
    ));

    println("Students (sorted alphabetically): " + set);

    Map<Student, List<Integer>> map = new TreeMap<>();
    set.forEach(s -> map.put(s, new ArrayList<>()));
    map.computeIfAbsent(new Student("Alice", 1), k -> new ArrayList<>())
            .addAll(List.of(85, 90, 92, 88));
    map.computeIfAbsent(new Student("Bob", 2), k -> new ArrayList<>())
            .addAll(List.of(70, 75, 80));
    map.computeIfAbsent(new Student("Charlie", 3), k -> new ArrayList<>())
            .addAll(List.of(95, 98, 91, 97));
    map.computeIfAbsent(new Student("Diana", 4), k -> new ArrayList<>())
            .addAll(List.of(60, 65, 70, 68));
    map.computeIfAbsent(new Student("Eve", 5), k -> new ArrayList<>())
            .addAll(List.of(88, 85, 90));

    System.out.println("\nGrade Report (sorted by name):");
    map.forEach((student, g) ->
            System.out.printf("  %-10s %s  avg: %.2f%n",
                    student.name(), g, average(g))
    );

    // Top student
    Map.Entry<Student, List<Integer>> top = map.entrySet().stream()
            .max(Comparator.comparingDouble(e -> average(e.getValue())))
            .orElseThrow();

    System.out.printf("%nTop student: %s with average %.2f%n",
            top.getKey().name(), average(top.getValue()));
}

double average(List<Integer> grades) {
    return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
}

record Student(String name, int studentId) implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return this.name().compareTo(o.name());
    }
}