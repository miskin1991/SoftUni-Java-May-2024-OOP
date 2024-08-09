package Exams._20240802_examPreparation.restaurant.models.waiter;

import Exams._20240802_examPreparation.restaurant.models.orders.TakenOrders;
import Exams._20240802_examPreparation.restaurant.models.orders.TakenOrdersImpl;

import static Exams._20240802_examPreparation.restaurant.common.ExceptionMessages.WAITER_EFFICIENCY_LESS_THAN_ZERO;
import static Exams._20240802_examPreparation.restaurant.common.ExceptionMessages.WAITER_NAME_NULL_OR_EMPTY;

public abstract class BaseWaiter implements Waiter {
    private String name;
    private int efficiency;
    private TakenOrders takenOrders;

    public BaseWaiter(String name, int efficiency) {
        setName(name);
        setEfficiency(efficiency);
        takenOrders = new TakenOrdersImpl();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setEfficiency(int efficiency) {
        if (efficiency < 0) {
            throw new IllegalArgumentException(WAITER_EFFICIENCY_LESS_THAN_ZERO);
        }
        this.efficiency = efficiency;
    }

    @Override
    public int getEfficiency() {
        return efficiency;
    }


    @Override
    public boolean canWork() {
        return efficiency > 0;
    }

    @Override
    public TakenOrders takenOrders() {
        return takenOrders;
    }
}
