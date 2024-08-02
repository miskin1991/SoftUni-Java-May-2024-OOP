package Exercise.IntefaceAndAbstraction.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();
        String[] tokens = scanner.nextLine().split(" ");
        while (!tokens[0].equals("End")) {
            Birthable birthable = switch (tokens[0]) {
                case "Citizen" -> new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                case "Pet" -> new Pet(tokens[1], tokens[2]);
                default -> null;
            };
            if (birthable != null)
                birthables.add(birthable);
            tokens = scanner.nextLine().split(" ");
        }

        String year = scanner.nextLine();

        birthables.stream()
                .filter(b -> b.getBirthDate().endsWith(year))
                .forEach(bb -> System.out.println(bb.getBirthDate()));
    }
}