import static java.lang.IO.println;

void main() {

    C c = new C();
}

class A {

    public A() {
        println("creating A");
    }
}

class B extends A {

    public B() {
        println("creating B");
    }
}

class C extends B {

    public C() {
        println("creating C");
    }
}