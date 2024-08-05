package Exercise.Polymorphism._02_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelLitresPerKm;
    private final double tankCapacity;

    public Vehicle(double fuelQuantity, double litresFuelPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelLitresPerKm = litresFuelPerKm;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelLitresPerKm(double fuelLitresPerKm) {
        this.fuelLitresPerKm = fuelLitresPerKm;
    }

    public double getLitresFuelPerKm() {
        return fuelLitresPerKm;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public String driving(double distance) {
        String message;
        DecimalFormat df = new DecimalFormat("#.##");

        double fuelNeeds = distance * getLitresFuelPerKm();
        if (fuelNeeds >= getFuelQuantity()) {
            message = "%s needs refueling".formatted(this.getClass().getSimpleName());
        } else {
            message =  "%s travelled %s km".formatted(this.getClass().getSimpleName(), df.format(distance));
            setFuelQuantity(getFuelQuantity() - fuelNeeds);
        }

        return message;
    }

    public void refueling(double fuel) {
        if (fuel <= 0.00) {
            System.out.println("Fuel must be a positive number");
        } else if (getFuelQuantity() + fuel > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(getFuelQuantity() + fuel);
        }
    }

    @Override
    public String toString() {
        return "%s: %.2f".formatted(this.getClass().getSimpleName(), getFuelQuantity());
    }
}
