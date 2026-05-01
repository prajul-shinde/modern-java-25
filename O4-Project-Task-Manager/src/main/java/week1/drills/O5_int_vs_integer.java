import static java.lang.IO.println;

static void main() {

    long start = System.nanoTime();
    Long sum = 0l;
    for (Integer i = 0; i < 1000000; i++)
        sum += i;
    println("Sum is %d.Time taken for wrapper: %dms ".formatted(sum, (System.nanoTime() - start) / 1000000));

    start = System.nanoTime();
    long sum2 = 0;
    for (var i = 0; i < 1000000; i++)
        sum2 += i;
    println("Sum is %d.Time taken for primitive: %dms ".formatted(sum, (System.nanoTime() - start) / 1000000));
}

