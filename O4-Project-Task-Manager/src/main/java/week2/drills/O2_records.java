void main() {
// Test Valid Inputs
    try {
        Temperature boilingWater = new Temperature(212, "F");
        Temperature absoluteZero = new Temperature(0, "K");
        Temperature niceDay = new Temperature(25, "C");

        System.out.println("212°F to Celsius: " + boilingWater.toCelsius() + "°C");
        System.out.println("0K to Celsius: " + absoluteZero.toCelsius() + "°C");
        System.out.println("25°C to Celsius: " + niceDay.toCelsius() + "°C");

    } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
    }

    System.out.println("---");

    // Test Invalid Input
    try {
        System.out.println("Attempting to create 100 Rankine (R)...");
        Temperature invalid = new Temperature(100, "R");
    } catch (IllegalArgumentException e) {
        System.out.println("Caught expected error: " + e.getMessage());
    }

}

record Temperature(double value, String unit) {
    Temperature {
        unit = unit.toUpperCase();
        if (!unit.matches("C|F|K")) throw new IllegalArgumentException("unit must be C F or K");
    }

    public double toCelsius() {
        return switch (unit) {
            case "C" -> value;
            case "F" -> (value - 32) * 5 / 9;
            case "K" -> value - 273.15;
            default -> throw new IllegalArgumentException();
        };
    }
}