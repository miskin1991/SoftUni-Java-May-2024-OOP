package Exams._20240802_examPreparation.restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {

    public HalfTimeWaiter(String name) {
        super(name, 4);
    }

    @Override
    public void work() {
        int efficiency = getEfficiency() - 2;
        setEfficiency(Math.max(efficiency, 0));
    }
}
