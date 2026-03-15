void main() {
    Pair<String, Integer> pair = new Pair<>("Alice", 30);
    System.out.println(pair);

    System.out.println("Swapped: " + pair.swap());
    System.out.println("Duplicate: " + Pair.duplicate("Java"));
    System.out.println("Contains \"Alice\"? " + pair.containsValue("Alice"));
    System.out.println("Contains 99? " + pair.containsValue(99));
}

static class Pair<F, S> {
    F first;
    S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    Pair<S, F> swap() {
        return new Pair<>(second, first);
    }

    static <T> Pair<T, T> duplicate(T value) {
        return new Pair<>(value, value);
    }

    boolean containsValue(Object value) {
        return (first != null && first.equals(value) || (second != null && second.equals(value)));
    }

    @Override
    public String toString() {
        return "(%s, %s)".formatted(first, second);
    }
}