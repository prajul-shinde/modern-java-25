import static java.lang.IO.println;


void main() {
    var result = getSome(); // not readable what type is it?
    var map = new HashMap<String, Integer>(); // correct
    for (var i = 0; i < 10; i++)
        println("hi " + 1);
}

int getSome() {
    return 0;
}
