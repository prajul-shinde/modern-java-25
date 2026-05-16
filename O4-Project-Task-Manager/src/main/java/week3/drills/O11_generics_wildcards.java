import static java.lang.IO.print;
import static java.lang.IO.println;

void main() {
    System.out.println("=== 1. Unbounded Wildcard ===");
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    printAll(names);

    System.out.println("\n=== 2. Upper Bounded Wildcard (Read) ===");
    List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
    System.out.println("Sum: " + sumNumbers(doubles));

    System.out.println("\n=== 3. Lower Bounded Wildcard (Write) ===");
    List<Number> numbers = new ArrayList<>();
    addIntegers(numbers);
    printAll(numbers);

    System.out.println("\n=== 4. PECS (Producer Extends, Consumer Super) ===");
    List<Integer> src = Arrays.asList(100, 200, 300);
    List<Number> dest = new ArrayList<>(Arrays.asList(1.1, 2.2));
    copy(dest, src);
    printAll(dest);
}

private <T> void copy(List<? super T> dest, List<? extends T> src) {
    for (T item : src)
        dest.add(item);
}

private void addIntegers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
    list.add(30);
}

private double sumNumbers(List<? extends Number> list) {
    double sum = 0;
    for (var num : list) {
        sum += num.doubleValue();
    }
    return sum;
}

private void printAll(List<?> list) {
    for (var item : list) {
        print("Item: " + item);
    }
    println();
}