package Exams._20240802_examPreparation.restaurant.models.waiter;


public class FullTimeWaiter extends BaseWaiter {

    public FullTimeWaiter(String name) {
        super(name, 8);
    }

    @Override
    public void work() {
        int efficiency = getEfficiency() - 1;
        setEfficiency(Math.max(efficiency, 0));
    }
}
