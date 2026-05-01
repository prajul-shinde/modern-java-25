import static java.lang.IO.println;


void main() {
    long start = System.nanoTime();
    String s = "a";
    for (var i = 0; i < 10_000; i++) {
        s += i;
    }
    println("Time taken using string : %dms".formatted((System.nanoTime() - start) / 1000_000));

    start = System.nanoTime();
    StringBuilder sb = new StringBuilder("a");
    for (var i = 0; i < 10_000; i++) {
        sb.append(" " + i);
    }
    println("Time taken using stringBuilder : %dms".formatted((System.nanoTime() - start) / 1000_000));
}
