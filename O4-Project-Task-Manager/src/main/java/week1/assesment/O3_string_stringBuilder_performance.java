import static java.lang.IO.println;

void main() {

    long start = System.nanoTime();
    String resultPlus = "";
    for (var i = 0; i < 50_000; i++)
        resultPlus += "a ";
    long timePlus = (System.nanoTime() - start)/1000_000;

    start = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (var i = 0; i < 50_000; i++)
        sb.append("a ");
    long timeAppend = (System.nanoTime() - start)/1000_000;
    long speedUp = timePlus / timeAppend;

    String report = """
            ===================================
            String vs StringBuilder Performance
            ===================================
            %-21s: %5dms
            %-21s: %5dms
            %-21s: %5dms
            %-21s: %5d%% fast
            ====================================
            """.formatted(
            "Iterations", 50_000,
            "String '+' operator", timePlus,
            "StringBuilder", timeAppend,
            "Speedup ratio", speedUp
    );
    println(report);

}