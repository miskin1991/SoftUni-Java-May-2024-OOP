package Exercise.Inheritance.Animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("Beast!")) {
            String type = command;
            String[] details = scanner.nextLine().split(" ");
            String name = details[0];
            int age = Integer.parseInt(details[1]);
            String gender = details[2];
            Animal animal = switch (type) {
                case "Cat" -> new Cat(name, age, gender);
                case "Dog" -> new Dog(name, age, gender);
                case "Frog" -> new Frog(name, age, gender);
                case "Kitten" -> new Kitten(name, age);
                case "Tomcat" -> new Tomcat(name, age);
                default -> null;
            };

            if (animal != null) {
                System.out.println(animal);
            }

            command = scanner.nextLine();
        }
    }
}
