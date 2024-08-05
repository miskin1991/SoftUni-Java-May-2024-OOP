package Exercise.Polymorphism._02_Vehicles;

public class Bus extends Vehicle {

    private final double emptyConsumption;
    private final double nonEmptyConsumption;

    public Bus(double fuelQuantity, double litresFuelPerKm, double tankCapacity) {
        super(fuelQuantity, litresFuelPerKm, tankCapacity);
        emptyConsumption = litresFuelPerKm;
        nonEmptyConsumption = litresFuelPerKm + 1.40;
    }

    @Override
    public String driving(double distance) {
        setFuelLitresPerKm(nonEmptyConsumption);
        return super.driving(distance);
    }

    public String drivingEmpty(double distance) {
        setFuelLitresPerKm(emptyConsumption);
        return super.driving(distance);
    }
}
