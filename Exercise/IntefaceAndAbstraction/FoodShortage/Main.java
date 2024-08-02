package Exercise.IntefaceAndAbstraction.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        int N = Integer.parseInt(scanner.nextLine());
        while (N > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            Person person = null;
            if (tokens.length == 3) {
                person = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else if (tokens.length == 4) {
                person = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            }

            if (person != null)
                persons.add(person);

            N--;
        }

        String option = scanner.nextLine();
        while (!option.equals("End")) {
            String name = option;
            Buyer buyer = (Buyer)persons.stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst().orElse(null);
            if (buyer != null)
                buyer.buyFood();
            option = scanner.nextLine();
        }

        System.out.println((int)persons.stream()
                .filter(p -> p instanceof Buyer)
                .mapToDouble(b -> ((Buyer) b).getFood())
                .sum());

    }
}
