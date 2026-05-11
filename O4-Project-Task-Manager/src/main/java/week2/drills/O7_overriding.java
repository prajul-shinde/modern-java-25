void main() {

    Parent p = new Parent();
    Parent c = new Child(); // Upcasting
    Child realChild = new Child();

    System.out.println("--- Static Hiding Tests ---");

    // Calls Parent version because the reference type is Parent
    p.staticMethod();

    // Calls Parent version! Even though the object is a Child.
    // This proves it is NOT polymorphic (not overridden).
    c.staticMethod();

    // Calls Child version because the reference type is Child
    realChild.staticMethod();

    System.out.println("\n--- Final Method Test ---");
    c.finalMethod(); // Works fine; Child inherits it but can't change it.
}

class Parent {
    // A final method cannot be overridden
    public final void finalMethod() {
        System.out.println("Parent: Final logic");
    }

    // A static method can be hidden
    public static void staticMethod() {
        System.out.println("Parent: Static logic");
    }
}

class Child extends Parent {

    /*
     * UNCOMMENTING THE BELOW WILL CAUSE A COMPILER ERROR:
     * "finalMethod() in Child cannot override finalMethod() in Parent;
     * overridden method is final"
     */
    // @Override
    // public void finalMethod() {
    //     System.out.println("Child: Attempting to override final");
    // }

    // This is NOT an override. This is "Method Hiding".
    public static void staticMethod() {
        System.out.println("Child: Static logic (Hiding Parent)");
    }
}