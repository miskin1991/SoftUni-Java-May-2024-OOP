package Exercise.Abstractions._04_TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lights[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Lights::valueOf)
                .toArray(Lights[]::new);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            updateLights(lights);
            printLights(lights);
        }
    }

    private static void printLights(Lights[] lights) {
        for (Lights light : lights) {
            System.out.print(light + " ");
        }
        System.out.println();
    }

    private static void updateLights(Lights[] lights) {
        for (int i = 0; i < lights.length; i++) {
            lights[i] = lights[i].next();
        }
    }
}
