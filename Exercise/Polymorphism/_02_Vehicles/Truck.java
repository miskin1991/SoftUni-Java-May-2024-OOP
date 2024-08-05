package Exercise.Polymorphism._02_Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litresFuelPerKm, double tankCapacity) {
        super(fuelQuantity, litresFuelPerKm + 1.60, tankCapacity);
    }

    @Override
    public void refueling(double fuel) {
        fuel *= 0.95;
        super.refueling(fuel);
    }
}
