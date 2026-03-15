void main() {

    Sorter<Integer> intSorter = new Sorter<>(List.of(5, 3, 9, 1, 2));
    System.out.println("min: " + intSorter.findMin() +
            ", max: " + intSorter.findMax() +
            ", sorted: " + intSorter.sort());

    Sorter<String> strSorter = new Sorter<>(List.of("banana", "apple", "mango"));
    System.out.println("min: " + strSorter.findMin() +
            ", max: " + strSorter.findMax() +
            ", sorted: " + strSorter.sort());

    Sorter<Student> studentSorter = new Sorter<>(List.of(
            new Student("Alice", 95),
            new Student("Charlie", 60),
            new Student("Bob", 78)
    ));
    System.out.println("min: " + studentSorter.findMin() +
            ", max: " + studentSorter.findMax() +
            ", sorted: " + studentSorter.sort());
}

class Sorter<T extends Comparable<T>> {

    List<T> items;

    public Sorter(List<T> items) {
        this.items = items;
    }

    T findMin() {
        return items.stream().min(Comparator.naturalOrder()).orElseThrow();
    }

    T findMax() {
        return items.stream().max(Comparator.naturalOrder()).orElseThrow();
    }

    List<T> sort() {
        return items.stream().sorted().toList();
    }
}

record Student(String name, int grade) implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.grade, o.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}