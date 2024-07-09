package Exercise.Abstractions._05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimensions = getArrayInput(scanner.nextLine());
            Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);

            String command = scanner.nextLine();
            while (!command.equals("Let the Force be with you"))
            {
                int[] playerData = getArrayInput(command);
                int[] evilData = getArrayInput(scanner.nextLine());

                Evil evil = new Evil(evilData[0],evilData[1]);
                galaxy.play(evil);

                Player player = new Player(playerData[0], playerData[1]);
                galaxy.play(player);

                command = scanner.nextLine();
            }

        System.out.println(galaxy.getScore());


    }

    private static int[] getArrayInput(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
