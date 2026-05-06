import static java.lang.IO.println;

//Write a program that demonstrates:

//        1. All 8 primitives declared and printed

//2. Autoboxing: add an `int` to an `ArrayList<Integer>` without explicit cast

//3. Integer cache: show `Integer.valueOf(100) == Integer.valueOf(100)` is true but `Integer.valueOf(200) == Integer.valueOf(200)` is false
//        4. NullPointerException risk: declare `Integer x = null` and safely handle unboxing
//5. Use `var` for at least 2 declarations where it makes sense
void main() {
    byte b = 2;
    short s = 2;
    int i = 2;
    long l = 2l;
    float f = 2.0f;
    double d = 2.0;
    boolean bool = false;
    char c = 'a';
    println(b);
    println(s);
    println(i);
    println(l);
    println(f);
    println(d);
    println(bool);
    println(c);
    var list = new ArrayList<Integer>();
    list.add(i);
    println("Integer.valueOf(100) == Integer.valueOf(100) : %s"
            .formatted(Integer.valueOf(100) == Integer.valueOf(100)));
    println("Integer.valueOf(200) == Integer.valueOf(200) : %s"
            .formatted(Integer.valueOf(200) == Integer.valueOf(200)));
    Integer x = null;
    var y = x == null ? 0 : x;
    println(y);
}