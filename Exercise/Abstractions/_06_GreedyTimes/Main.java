
package Exercise.Abstractions._06_GreedyTimes;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] storage = scanner.nextLine().split("\\s+");

        Bag bag = new Bag();

        for (int i = 0; i < storage.length; i += 2) {
            Resource resource = new Resource(storage[i], Long.parseLong(storage[i + 1]));

            if (resource.isEmpty()) {
                continue;
            } else if (input < bag.getAllResourcesSum() + resource.getAmount()) {
                continue;
            }

            String name = resource.getName();
            switch (name) {
                case "Gem":
                    if (!bag.containsResource(name)) {
                        if (bag.containsResource("Gold")) {
                            if (resource.getAmount() > bag.getResourceSumByName("Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.getResourceSumByName(name) + resource.getAmount()
                                > bag.getResourceSumByName("Gold")) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsResource(name)) {
                        if (bag.containsResource("Gem")) {
                            if (resource.getAmount() > bag.getResourceSumByName("Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.getResourceSumByName(name) + resource.getAmount()
                                    > bag.getResourceSumByName("Gem")) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsResource(name)) {
                bag.createNewResource(name);
            }

            bag.getResource(name).putIfAbsent(name, 0L);


            bag.getResource(name).put(name, bag.getResource(name).get(name) + resource.getAmount());
        }

        for (var x : bag) {
            String name = x.getKey();
            System.out.printf("<%s> $%s%n", name, bag.getResourceSumByName(name));
            System.out.println(bag.getResourcesStats(name));

        }
    }
}