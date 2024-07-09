package Labs.Abstractions._04_HotelReservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double price = PriceCalculator.calculatePrice(Double.parseDouble(tokens[0]), Integer.parseInt(tokens[1]),
                Season.valueOf(tokens[2].toUpperCase()), Discount.valueOf(tokens[3].toUpperCase()));
        System.out.printf("%.2f%n", price);
    }
}
