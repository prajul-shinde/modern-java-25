import static java.lang.IO.println;

void main() {

    var circle = new Circle(5);
    var rectangle = new Rectangle(5, 4);
    Shape[] shapes = {circle, rectangle};
    for (var shape : shapes)
        shape.printInfo();
}

abstract class Shape {

    abstract double calculateArea();

    void printInfo() {
        println("%s area: %.2f".formatted(getClass().getSimpleName(), calculateArea()));
    }
}

class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 3.14 * (radius * radius);
    }
}

class Rectangle extends Shape {

    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}