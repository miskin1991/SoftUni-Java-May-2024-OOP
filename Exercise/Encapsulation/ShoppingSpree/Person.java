package Exercise.Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.nameValidator(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setMoney(double money) {
        Validator.moneyValidator(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > money) {
            String message = "%s can't afford %s".formatted(name, product.getName());
            throw new IllegalArgumentException(message);
        }
        this.products.add(product);
        this.money -= product.getCost();
        System.out.printf("%s bought %s\n", this.name, product.getName());
    }
}
