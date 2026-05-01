import static java.lang.IO.println;


void main() {
    Integer num = null;
    int num1 = safeConvert(num);
    println(num1);
}

int safeConvert(Integer num) {
    return num == null ? 0 : num;
}
