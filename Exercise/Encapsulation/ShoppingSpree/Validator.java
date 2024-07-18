package Exercise.Encapsulation.ShoppingSpree;

public class Validator {
    public static void nameValidator(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public static void moneyValidator(double money) {
        if (money < 0.0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }
}
