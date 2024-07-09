package Labs.Abstractions._04_HotelReservation;

public enum Discount {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private final int value;

    Discount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
