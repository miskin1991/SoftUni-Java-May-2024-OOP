package Labs.Encapsulations._04_FirstAndReserveTeam;

import Labs.Encapsulations.Person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name) {
        setName(name);
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    void addPlayer(Person person) {
        if (person.getAge() < 40) {
            firstTeam.add(person);
        } else {
            reserveTeam.add(person);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return List.copyOf(reserveTeam);
    }
}
