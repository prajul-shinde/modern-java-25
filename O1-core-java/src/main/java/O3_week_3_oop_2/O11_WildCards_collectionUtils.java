void main() {

    List<Integer> src = List.of(1, 2, 3);
    List<Number> dest = new ArrayList<>();
    CollectionUtils.copy(src, dest);
    System.out.println("After copy: " + dest);

    // printList
    List<Object> mixed = List.of("hello", 42, 3.14);
    System.out.println("List contents:");
    CollectionUtils.printList(mixed);

    // addNumbers
    List<Number> numbers = new ArrayList<>();
    CollectionUtils.addNumbers(numbers, 5);
    System.out.println("Numbers 1-5 added: " + numbers);

    // contains
    System.out.println("Contains 3? " + CollectionUtils.contains(numbers, 3));
    System.out.println("Contains 99? " + CollectionUtils.contains(numbers, 99));
}

class CollectionUtils {

    static <T> void copy(List<? extends T> src, List<? super T> dest) {
        dest.addAll(src);
    }

    static void printList(List<?> list) {
        list.forEach(System.out::println);
    }

    static void addNumbers(List<? super Integer> list, int count) {
        for (int i = 1; i <= count; i++) list.add(i);
    }

    static boolean contains(Collection<?> collection, Object item) {
        return collection.contains(item);
    }
}