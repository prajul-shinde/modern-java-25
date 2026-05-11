class Calculator {

    public int add(int a, int b) {
        System.out.print("Running add(int, int): ");
        return a + b;
    }

    // Overload 2: Two doubles
    public double add(double a, double b) {
        System.out.print("Running add(double, double): ");
        return a + b;
    }

    // Overload 3: Three integers
    public int add(int a, int b, int c) {
        System.out.print("Running add(int, int, int): ");
        return a + b + c;
    }

    // Overload 4: Two Strings (Concatenation)
    public String add(String a, String b) {
        System.out.print("Running add(String, String): ");
        return a + b;
    }
}

void main() {

    var calc = new Calculator();
    System.out.println(calc.add(5, 10));
    System.out.println(calc.add(10.5, 20.5));
    System.out.println(calc.add(1, 2, 3));
    System.out.println(calc.add("Hello ", "World"));
}