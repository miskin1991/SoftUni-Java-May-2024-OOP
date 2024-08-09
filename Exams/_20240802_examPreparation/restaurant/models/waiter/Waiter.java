package Exams._20240802_examPreparation.restaurant.models.waiter;

import Exams._20240802_examPreparation.restaurant.models.orders.TakenOrders;

public interface Waiter {
    String getName();

    int getEfficiency();

    boolean canWork();

    TakenOrders takenOrders();


    void work();
}
