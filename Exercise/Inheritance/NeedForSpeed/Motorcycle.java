package Exercise.Inheritance.NeedForSpeed;

public class Motorcycle extends Vehicle {

    public Motorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(8.0);
    }

}
