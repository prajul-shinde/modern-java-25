import static java.lang.IO.*;

void main() {

    println("=== Temperature convertor ===");
    double celsius = Double.parseDouble(readln("Enter temperature in celsius: "));
    double fahrenheit = (celsius * 9 / 5) + 32;
    double kelvin = celsius + 273.15;
    String result = """
            Temperature conversions:
            =======================
                Celsius: %8.2f°C
                Fahrenheit: %5.2f°F
                Kelvin: %10.2fK
            
            Formula details:
            -----------------------
                °F = (°C × 9/5) + 32
                 K  = °C + 273.15
            -----------------------
            ========================
            """.formatted(celsius, fahrenheit, kelvin);
    print(result);
}