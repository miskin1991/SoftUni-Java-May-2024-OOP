package Labs.Abstractions._02_PointInRectangle;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangle rectangle = createRectangle(scanner);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] pointCoordinates = getPointCoordinates(scanner);
            Point point = createPointFromCoordinates(pointCoordinates, 0, 1);
            System.out.println(rectangle.contains(point));
        }
    }

    private static Rectangle createRectangle(Scanner scanner) {
        int[] rectangleCoordinates = getPointCoordinates(scanner);
        return new Rectangle(
                createPointFromCoordinates(rectangleCoordinates, 0, 1),
                createPointFromCoordinates(rectangleCoordinates, 2, 3)
        );
    }

    private static int[] getPointCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static Point createPointFromCoordinates(int[] rectangleCoordinates, int x, int y) {
        return new Point(rectangleCoordinates[x], rectangleCoordinates[y]);
    }
}
