void main() {
    // 1. Create 2 of each shape as requested
    List<Shape> shapes = List.of(
            new Circle(5.0),
            new Circle(2.5),
            new Rectangle(4.0, 6.0),
            new Rectangle(3.0, 10.0),
            new Triangle(4.0, 5.0),
            new Triangle(6.0, 8.0)
    );

    // 2. Print total area using polymorphism
    System.out.println("=== Total Area Calculation ===");
    System.out.printf("Total combined area: %.2f%n%n", totalArea(shapes));

    // 3. Print details and describe each shape using pattern matching
    System.out.println("=== Shape Breakdown ===");
    for (Shape shape : shapes) {
        shape.printDetails();                    // Standard default interface method
        System.out.println(describeShape(shape)); // Switch pattern matching string
        System.out.println("-".repeat(40));
    }
}

// --- Interfaces ---

// Printable interface with a default layout method
interface Printable {
    double area(); // Forces types implementing this to provide area logic

    default void printDetails() {
        System.out.println("[" + getClass().getSimpleName() + "] calculated area: " + String.format("%.2f", area()));
    }
}

// Sealed interface constraining the permitted domain models
sealed interface Shape extends Printable permits Circle, Rectangle, Triangle {
    // Implicitly requires area() because it extends Printable
}

// --- Records (All shapes are immutable data containers) ---

record Circle(double radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

record Rectangle(double width, double height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}

record Triangle(double base, double height) implements Shape {
    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// --- Service / Helper Logic methods ---

// Polymorphic loop calculating total area
double totalArea(List<Shape> shapes) {
    double sum = 0.0;
    for (Shape s : shapes) {
        sum += s.area(); // Polymorphism at work: invokes specific override at runtime
    }
    return sum;
}

// Switch pattern matching demonstrating data extraction from properties directly inside cases
String describeShape(Shape s) {
    return switch (s) {
        case Circle c -> " -> Details: It's a perfect circle with a radius of " + c.radius();
        case Rectangle r -> " -> Details: It's a box with width " + r.width() + " and height " + r.height();
        case Triangle t ->
                " -> Details: It's a triangle stabilizing a base of " + t.base() + " and height " + t.height();
    }; // No default case is necessary here! Java knows the sealed interface is exhaustively checked.
}