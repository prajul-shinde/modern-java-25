import static java.lang.IO.println;

sealed interface Exp permits Const, Add, Multiply {
}

record Const(int value) implements Exp {
}

record Add(Exp left, Exp right) implements Exp {
}

record Multiply(Exp left, Exp right) implements Exp {
}

double eval(Exp exp) {
    return switch (exp) {
        case Const c -> c.value();
        case Add a -> eval(a.left()) + eval(a.right());
        case Multiply m -> eval(m.left()) * eval(m.right());
    };
}

void main() {

    Exp expression = new Multiply(
            new Add(new Const(10), new Const(5)),
            new Const(2)
    );

    double result = eval(expression);
    println("The result of (10 + 5) * 2 is: " + result);
}