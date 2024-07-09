package Labs.Abstractions._03_Students;

public record Student(String name, int age, double grade) {

    private String getStatus() {
        if (this.grade() >= 5.00) {
            return "Excellent student.";
        } else if (this.grade() < 5.00 && this.grade() >= 3.50) {
            return "Average student.";
        } else {
            return " Very nice person.";
        }
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old. %s", this.name(), this.age(), this.getStatus());
    }
}
