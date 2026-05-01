import static java.lang.IO.println;


void main() {
    long start = System.nanoTime();
    long sum = 0;
    for (var i = 0; i < 10_00000; i++)
        sum += i;
    println("Sums is %d and time taken %dms".formatted(sum, (System.nanoTime() - start) / 1000_000));
}

