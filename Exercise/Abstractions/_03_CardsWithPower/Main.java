package Exercise.Abstractions._03_CardsWithPower;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RankPowers rank = RankPowers.valueOf(scanner.nextLine());
        SuitPowers suit = SuitPowers.valueOf(scanner.nextLine());

        int power = rank.getPower() + suit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, power);

    }
}
