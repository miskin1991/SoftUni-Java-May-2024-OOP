package Exercise.Encapsulation.ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    private void setName(String name) {
        Validator.nameValidator(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setCost(double cost) {
        Validator.moneyValidator(cost);
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
