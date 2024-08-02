package Exercise.Inheritance.Animals;

public abstract class Animal {
    private final String INVALID_INPUT = "Invalid input!";
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public abstract String produceSound();

    @Override
    public String toString() {
        String sb = this.getClass().getSimpleName() + System.lineSeparator() +
                String.format("%s %d %s", getName(), getAge(), getGender()) + System.lineSeparator() +
                produceSound() + System.lineSeparator();
        return sb.trim();
    }
}
