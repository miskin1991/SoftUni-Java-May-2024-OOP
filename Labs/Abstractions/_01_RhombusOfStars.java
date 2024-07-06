package Labs.Abstractions;

import java.util.Scanner;

public class _01_RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        // print top part
        for (int i = 1; i <= size - 1; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // print middle part
        for (int i = 1; i <= size; i++) {
            System.out.print("* ");
        }
        System.out.println();

        // print top part
        for (int i = size - 1; i >= 1 ; i--) {
            for (int j = size - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
