package Exercise.Polymorphism._01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private final double fuelLitresPerKm;

    public Vehicle(double fuelQuantity, double litresFuelPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelLitresPerKm = litresFuelPerKm;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitresFuelPerKm() {
        return fuelLitresPerKm;
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
        setFuelQuantity(getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return "%s: %.2f".formatted(this.getClass().getSimpleName(), getFuelQuantity());
    }
}
