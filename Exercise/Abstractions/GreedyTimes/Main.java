package Exercise.Abstractions.GreedyTimes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(capacity);

        String[] items = scanner.nextLine().split("\\s+");

        for (int i = 0; i < items.length; i += 2) {
            String item = items[i];
            long value = Long.parseLong(items[i + 1]);

            if (item.equals("Gold")) {
                bag.addGold(value);
            } else if (item.length() == 3) {
                bag.addCash(item, value);
            } else if (item.length() > 3 && item.toLowerCase().endsWith("gem")) {
                bag.addGem(item, value);
            }
        }

        System.out.print(bag);
    }
}
