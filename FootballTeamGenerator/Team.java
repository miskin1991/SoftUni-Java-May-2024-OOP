package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player p)
    {
        players.add(p);
    }

    public void removePlayer(String playerName) {
        boolean removed = players.removeIf(p -> p.getName().equals(playerName));
        if (!removed) {
            System.out.printf("Player %s is not in %s team.%n", playerName, getName());
        }
    }

    public double getRating() {
        double renting = 0.0;
        for (Player p : players) {
            renting += p.overallSkillLevel();
        }
        return renting;
    }
}
