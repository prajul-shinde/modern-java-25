import static java.lang.IO.println;

sealed interface Exp permits Num, Add, Sub {
}

record Num(double value) implements Exp {
}

record Add(Exp left, Exp right) implements Exp {
}

record Sub(Exp left, Exp right) implements Exp {
}

double evaluate(Exp exp) {
    return switch (exp) {
        case Num(double value) -> value;
        case Add(Exp left, Exp right) -> evaluate(left) + evaluate(right);
        case Sub(Exp left, Exp right) -> evaluate(left) - evaluate(right);
    };
}

String prettyPrint(Exp exp) {
    return switch (exp) {
        case Num(double value) -> String.valueOf(value);
        case Add(Exp left, Exp right) -> "(%s + %s)".formatted(prettyPrint(left), prettyPrint(right));
        case Sub(Exp left, Exp right) -> "(%s - %s)".formatted(prettyPrint(left), prettyPrint(right));
    };
}

void main() {
//    ((10 + 20)) - (20 - 4)
    Exp exp = new Sub(
            new Add(new Num(10.0), new Num(20.0)),
            new Sub(new Num(20.0), new Num(4.0))
    );
    println("Expression: " + prettyPrint(exp));
    println("Result: " + evaluate(exp));
}