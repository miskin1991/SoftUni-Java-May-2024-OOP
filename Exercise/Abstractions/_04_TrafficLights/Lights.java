package Exercise.Abstractions._04_TrafficLights;

public enum Lights {
    RED,
    GREEN,
    YELLOW;

    public Lights next() {
        return switch (this) {
            case RED -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        };
    }
}
