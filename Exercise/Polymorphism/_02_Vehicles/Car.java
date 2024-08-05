package Exercise.Polymorphism._02_Vehicles;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double litresFuelPerKm, double tankCapacity) {
        super(fuelQuantity, litresFuelPerKm + 0.90, tankCapacity);
    }
}
