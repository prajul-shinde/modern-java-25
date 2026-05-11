abstract class Vehicle {

    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    abstract void start();

    abstract void stop();

    abstract String fuelType();

    public void describe() {
        System.out.println("Vehicle: " + model + " | Fuel: " + fuelType());
    }

    protected String getModel() {
        return model;
    }
}

class Car extends Vehicle {

    private int numDoors;

    public Car(String model, int numDoors) {
        super(model);
        this.numDoors = numDoors;
    }

    @Override
    void start() {
        System.out.println(getModel() + ": Performing seatbelt check...");
        System.out.println(getModel() + ": Engine started.");
    }

    @Override
    void stop() {
        System.out.println(getModel() + ": Engine stopped.");
    }

    @Override
    String fuelType() {
        return "Petrol";
    }
}

class ElectricCar extends Car {
    private int batteryRange;

    public ElectricCar(String model, int numDoors, int batteryRange) {
        super(model, numDoors);
        this.batteryRange = batteryRange;
    }

    @Override
    public void start() {
        System.out.println(getModel() + ": Performing battery health check...");
        super.start(); // Calls Car's start (Seatbelt check + Engine start)
    }

    @Override
    public String fuelType() {
        return "Electric";
    }
}

void main() {
    Vehicle[] fleet = {
            new Car("Sedan GT", 4),
            new ElectricCar("Model S", 4, 400),
            new Car("Coupe X", 2)
    };

    System.out.println("--- Fleet Operations ---");
    for (Vehicle v : fleet) {
        v.describe();
        v.start();
        System.out.println("------------------------");
    }
}