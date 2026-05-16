import static java.lang.IO.print;

void main() {

    // ==========================================
    // PART A: Testing Stack<T> [8 Marks]
    // ==========================================
    System.out.println("=== PART A: Generic Stack ===");

    // Testing Stack<String>
    Stack<String> stringStack = new Stack<>();
    stringStack.push("Java");
    stringStack.push("Generics");
    System.out.println("String Stack Size: " + stringStack.size()); // 2
    System.out.println("Peek String: " + stringStack.peek());       // Generics
    System.out.println("Pop String: " + stringStack.pop());         // Generics
    System.out.println("Is Empty? " + stringStack.isEmpty());        // false

    // Testing Stack<Integer>
    Stack<Integer> intStack = new Stack<>();
    intStack.push(42);
    intStack.push(99);
    System.out.println("Pop Integer: " + intStack.pop());           // 99
    System.out.println("Pop Integer: " + intStack.pop());           // 42
    System.out.println("Is Empty now? " + intStack.isEmpty());     // true

    // ==========================================
    // PART B: Testing Wildcard Methods [12 Marks]
    // ==========================================
    System.out.println("\n=== PART B: Wildcards & Bounded Parameters ===");

    // 1. Test printAll
    System.out.print("1. printAll output: ");
    printAll(Arrays.asList("A", "B", "C"));

    // 2. Test sumAll
    List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.0);
    System.out.println("2. sumAll output: " + sumAll(doubleList)); // 7.0

    // 3. Test addNumbers
    List<Number> numContainer = new ArrayList<>(Arrays.asList(1.1, 2.2));
    addNumbers(numContainer);
    System.out.print("3. addNumbers output: ");
    printAll(numContainer); // Should show the added integers at the end

    // 4. Test findMax
    List<Integer> scores = Arrays.asList(45, 89, 12, 73);
    List<String> names = Arrays.asList("Zachary", "Alice", "Charlie");
    System.out.println("4a. findMax (Integer): " + findMax(scores)); // 89
    System.out.println("4b. findMax (String): " + findMax(names));   // Zachary
}

<T> void printAll(List<T> items) {
    for (var item : items)
        print(item + " ");
}

double sumAll(List<? extends Number> numbers) {
    double sum = 0.0;
    for (var num : numbers)
        sum += num.doubleValue();
    return sum;
}

void addNumbers(List<? super Integer> list) {
    list.add(100);
    list.add(200);
}

<T extends Comparable<T>> T findMax(List<T> items) {
    if (items == null || items.isEmpty()) return null;
    T max = items.get(0);
    for (T item : items) {
        if (item.compareTo(max) > 0)
            max = item;
    }
    return max;
}

class Stack<T> {

    private final List<T> elements = new ArrayList<T>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return elements.get(elements.size() - 1);
    }

    public int size() {
        return elements.size();
    }

    private boolean isEmpty() {
        return elements.isEmpty();
    }
}