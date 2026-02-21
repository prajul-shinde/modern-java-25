import static java.lang.IO.println;

void main() {

    int i1 = 100;
    int i2 = 100;
    println("primitives: i1 == i2: " + (i1 == i2)); // true

//    wrappers cached   // -128 to 127 are cached
    Integer i3 = 100;
    Integer i4 = 100;
    println("Wrappers cached: i3 == i4: " + (i3 == i4));  // true

//    wrappers non cached
    Integer i5 = 128;
    Integer i6 = 128;
    println("Wrappers non cached: i5 == i6: " + (i5 == i6));  // false
    println("Wrappers non cached: i5.equals(i6): " + (i5.equals(i6)));  // true

//    null handling
    Integer n1 = null;
    int n2 = n1 == null ? 0 : n1;
    println("null handling default value: " + n2);  // 0
}