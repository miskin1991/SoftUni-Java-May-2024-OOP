package Exercise.IntefaceAndAbstraction.FoodShortage;

public class Rebel implements Buyer, Person {
    private final String name;
    private final int age;
    private final String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        food = 0;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
