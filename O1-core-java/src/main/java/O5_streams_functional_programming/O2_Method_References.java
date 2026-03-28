import static java.lang.IO.println;

void main() {

    Function<String, Integer> f1 = String::length;
    Predicate<String> p1 = String::isEmpty;
    Consumer<String> c1 = System.out::println;
    Function<String, Integer> f2 = Integer::parseInt;
    Comparator<String> c2 = String::compareTo;
    Supplier<ArrayList<String>> s1 = ArrayList::new;
    Function<String, String> f3 = String::toUpperCase;
    BinaryOperator<Integer> b1 = Integer::max;

    // sort
    List<String> names = new ArrayList<>(List.of("Charlie", "Alice", "Bob"));
    names.sort(Comparator.comparing(String::length));
    println(names);


    // Parse integers
    List<String> numStrs = List.of("10", "20", "30");
    List<Integer> parsed = numStrs.stream().map(Integer::parseInt).toList();
    println("Parsed integers: " + parsed);

    // Constructor reference: String -> User
    List<String> userNames = List.of("Alice", "Bob", "Charlie");
    List<User> users = userNames.stream().map(User::new).toList();
    users.stream().map(User::name).forEach(System.out::println);


}

record User(String name) {
}