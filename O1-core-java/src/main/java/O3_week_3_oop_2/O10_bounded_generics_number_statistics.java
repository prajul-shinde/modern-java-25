void main() {
    List<Integer> ints = List.of(1, 3, 5, 7, 9);
    System.out.printf("Integers: sum=%.2f, avg=%.2f, min=%.2f, max=%.2f%n",
            NumberStats.sum(ints), NumberStats.average(ints),
            NumberStats.min(ints), NumberStats.max(ints));

    List<Double> doubles = List.of(1.5, 2.75, 3.5, 9.5);
    System.out.printf("Doubles:  sum=%.2f, avg=%.2f, min=%.2f, max=%.2f%n",
            NumberStats.sum(doubles), NumberStats.average(doubles),
            NumberStats.min(doubles), NumberStats.max(doubles));
}

class NumberStats {
    static <T extends Number> double sum(Collection<T> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }

    static <T extends Number> double average(Collection<T> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).average().orElse(0);
    }

    static <T extends Number> double min(Collection<T> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).min().orElse(0);
    }

    static <T extends Number> double max(Collection<T> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).max().orElse(0);
    }
}