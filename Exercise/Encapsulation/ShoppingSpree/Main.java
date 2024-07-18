package Exercise.Encapsulation.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Person> persons = new LinkedHashMap<>();
        parseCommand(command, persons, Person::new);
        command = scanner.nextLine();
        Map<String, Product> products = new LinkedHashMap<>();
        parseCommand(command, products, Product::new);

        command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split(" ");
            String name = tokens[0];
            String productName = tokens[1];

            Person person = persons.get(name);
            Product product = products.get(productName);
            person.buyProduct(product);

            command = scanner.nextLine();
        }

        persons.values().forEach(System.out::println);

    }

    public static <T> void parseCommand(String command, Map<String, T> map, BiFunction<String, Double, T> constructor) {
        String[] tokens = command.split(";");
        for (String token : tokens) {
            String[] data = token.split("=");
            String name = data[0];
            double money = Double.parseDouble(data[1]);
            T object = constructor.apply(name, money);
            map.put(name, object);
        }
    }
}
