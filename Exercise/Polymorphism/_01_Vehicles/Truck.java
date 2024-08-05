package Exercise.Polymorphism._01_Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litresFuelPerKm) {
        super(fuelQuantity, litresFuelPerKm + 1.60);
    }

    @Override
    public void refueling(double fuel) {
        fuel *= 0.95;
        super.refueling(fuel);
    }
}
