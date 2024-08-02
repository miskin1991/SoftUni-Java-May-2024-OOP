package Exercise.IntefaceAndAbstraction.BirthdayCelebrations;

public class Pet implements Birthable {
    private final String name;
    private final String birthDate;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthDate = birthday;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
