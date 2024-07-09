package Labs.Encapsulations.Person;

import java.security.InvalidParameterException;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 0.0);
    }

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", firstName, lastName, getSalary());
    }

    public void increaseSalary(double bonus) {
        if (age < 30) {
            bonus /= 2;
        }
        double oldSalary = getSalary();
        double newSalary = oldSalary + (oldSalary * (bonus / 100));
        setSalary(newSalary);
    }

    public void setSalary(double salary) {
        if (salary < 460.00) {
            throw new InvalidParameterException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last");
        this.lastName = lastName;
    }

    public void validateName(String name, String prefix) {
        if (name.length() < 3) {
            throw new InvalidParameterException(prefix + " name cannot be less than 3 symbols");
        }
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new InvalidParameterException("Age cannot be zero or negative");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
