package Labs.Abstractions;

import java.util.Scanner;

public class _01_RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        printTopPart(size);
        printMiddlePart(size);
        printBottomPart(size);
    }

    private static void printBottomPart(int size) {
        for (int i = size - 1; i >= 1 ; i--) {
            printRepeatedString(" ", size - i);
            printRepeatedString("* ", i);
            System.out.println();
        }
    }

    private static void printMiddlePart(int size) {
        printRepeatedString("* ", size);
        System.out.println();
    }

    private static void printTopPart(int size) {
        for (int i = 1; i <= size - 1; i++) {
            printRepeatedString(" ", size - i);
            printRepeatedString("* ", i);
            System.out.println();
        }
    }

    public static void printRepeatedString(String str, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(str);
        }
    }
}
