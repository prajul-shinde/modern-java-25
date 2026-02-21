import static java.lang.IO.println;

void main() {

    var iterations = 50_000;
    long start = System.nanoTime();

//    test1
    String s = "";
    for (var i = 0; i < iterations; i++)
        s += "a ";
    long stringTime = (System.nanoTime() - start) / 1000_000;

//    test2
    start = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (var i = 0; i < iterations; i++)
        sb.append("a");
    long stringBuilderTime = (System.nanoTime() - start) / 1000_000;

    String result = """
            === Performance Test Result ===
            Iterations: %19d
            String time taken: %10d ms
            StringBuilder time taken: %d ms
            Speedup: %22.1fx faster
            """.formatted(
            iterations,
            stringTime,
            stringBuilderTime,
            (double) stringTime / stringBuilderTime);
    println(result);
}