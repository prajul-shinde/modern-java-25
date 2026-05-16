void main() {

    System.out.println(describe("Hello World"));
    System.out.println(describe(42));
    System.out.println(describe(3.14159));
    System.out.println(describe(Arrays.asList("Java", "Pattern", "Matching")));
    System.out.println(describe(null));
    System.out.println(describe(true)); // Test an unhandled type
}

String describe(Object obj) {
    return switch (obj) {
        case null -> "The object is null.";
        case String s -> "It's a String of length " + s.length() + ": \"" + s + "\"";
        case Integer i -> "It's an Integer with value: " + i;
        case Double d -> "It's a Double with value: " + d;
        case List<?> l -> "It's a List containing " + l.size() + " element(s).";
        default -> "It's an unhandled type: " + obj.getClass().getSimpleName();
    };
}