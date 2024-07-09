package Labs.Encapsulations._04_FirstAndReserveTeam;

import Labs.Encapsulations.Person.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split(" ");
            try {
                people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        Team team = new Team("Black Eagles");
        for (Person person : people) {
            team.addPlayer(person);
        }

        List<Person> firstTeam = team.getFirstTeam();
        List<Person> reserveTeam = team.getReserveTeam();

        System.out.printf("First team have %d players%n", firstTeam.size());
        System.out.printf("Reserve team have %d players%n", reserveTeam.size());


    }
}
