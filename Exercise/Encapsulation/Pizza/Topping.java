package Exercise.Encapsulation.Pizza;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies")
                || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place %s on top of your pizza.".formatted(toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1.0 && weight <= 50.0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("%s weight should be in the range [1..50].".formatted(weight));
        }
    }

    public double calculateCalories() {
        double coefficient = 0.0;
        switch (toppingType) {
            case "Meat" -> coefficient = 1.2;
            case "Veggies" -> coefficient = 0.8;
            case "Cheese" -> coefficient = 1.1;
            case "Sauce" -> coefficient = 0.9;
        }
        return ((2 * weight) * coefficient);
    }
}
