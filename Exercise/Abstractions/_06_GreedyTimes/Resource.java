package Exercise.Abstractions._06_GreedyTimes;

public class Resource {
    private String name;
    private long amount;

    public Resource(String name, long value) {
        amount = value;
        this.name = "";
        if (name.length() == 3) {
            this.name = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            this.name = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            this.name = "Gold";
        }
    }

    public boolean isEmpty() {
        return name.isEmpty();
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }
}
