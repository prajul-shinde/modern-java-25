import static java.lang.IO.println;

void main() {

}

public class C implements A, B {
    @Override
    public void hello() {
        println("Hello from Class C (Conflict Resolved!)");
    }
}

interface A {
    default void hello() {
        println("Hello from Interface A");
    }
}

interface B {
    default void hello() {
        println("Hello from Interface B");
    }
}