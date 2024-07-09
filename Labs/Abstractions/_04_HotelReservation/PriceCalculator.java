package Labs.Abstractions._04_HotelReservation;

public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int days, Season season, Discount discount) {
        return pricePerDay * days * season.getValue() * (1 - discount.getValue() / 100.0);
    }
}
