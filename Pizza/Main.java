package Pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));

        tokens = scanner.nextLine().split("\\s+");
        Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
        pizza.setDough(dough);

        tokens = scanner.nextLine().split("\\s+");
        while (tokens[0].equals("Topping")) {
            Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
            pizza.addTopping(topping);
            tokens = scanner.nextLine().split("\\s+");
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
