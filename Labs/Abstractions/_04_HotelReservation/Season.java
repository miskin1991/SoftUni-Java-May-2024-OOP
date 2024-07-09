package Labs.Abstractions._04_HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private final int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
