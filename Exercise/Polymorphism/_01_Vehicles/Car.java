package Exercise.Polymorphism._01_Vehicles;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double litresFuelPerKm) {
        super(fuelQuantity, litresFuelPerKm + 0.90);
    }
}
