import static java.lang.IO.println;

void main() {

    List<Vehicle> vehicles = List.of(
            new Car("Tesla Model 3", 5, true),
            new Car("Toyota Sienna", 8, false),
            new Car("Honda Civic", 5, false),
            new Bike("Ural", true),
            new Bike("Yamaha", false),
            new Truck("Volvo", 15.0),
            new Truck("Ford Ranger", 1.5)
    );
    for (Vehicle v : vehicles) {
        String brand = switch (v) {
            case Car c -> c.brand();
            case Bike b -> b.brand();
            case Truck t -> t.brand();
        };
        println(brand + " → " + categorize(v));
    }
}

sealed interface Vehicle permits Car, Bike, Truck {
}

record Car(String brand, int seats, boolean isElectric) implements Vehicle {
}

record Bike(String brand, boolean hasSidecar) implements Vehicle {
}

record Truck(String brand, double payloadTons) implements Vehicle {
}

String inspectVehicle(Vehicle v) {
    if (v instanceof Car c && c.seats() > 4)
        return "%s is a large car with %d seats".formatted(c.brand(), c.seats());
    return v.toString();
}

String categorize(Vehicle v) {

    return switch (v) {
        case Car c when c.isElectric() -> "Eco-friendly car";
        case Car c when c.seats() > 4 -> "Large car";
        case Car c -> "Standard car";
        case Bike b when b.hasSidecar() -> "Sidecar bike";
        case Bike b -> "Solo bike";
        case Truck t when t.payloadTons() > 10 -> "Heavy truck";
        case Truck t -> "Light truck";
    };

}