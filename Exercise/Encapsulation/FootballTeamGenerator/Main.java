package Exercise.Encapsulation.FootballTeamGenerator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split(";");
            switch (tokens[0]) {
                case "Team":
                    try {
                        teams.add(new Team(tokens[1]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add": {
                    String teamName = tokens[1];
                    Team team = getTeam(teams, teamName);
                    if (team != null) {
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        try {
                            team.addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case "Remove": {
                    String teamName = tokens[1];
                    Team team = getTeam(teams, teamName);
                    if (team != null) {
                        String playerName = tokens[2];
                        team.removePlayer(playerName);
                    }
                    break;
                }
                case "Rating": {
                    String teamName = tokens[1];
                    Team team = getTeam(teams, teamName);
                    if (team != null) {
                        System.out.printf("%s - %.0f%n", teamName, team.getRating());
                    }
                    break;
                }
                default:
                    break;
            }
            command = scanner.nextLine();
        }
    }

    private static Team getTeam(List<Team> teams, String teamName) {
        Team team = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElse(null);
        if (team == null) {
            System.out.printf("Team %s does not exist.%n", teamName);
        }
        return team;
    }
}
