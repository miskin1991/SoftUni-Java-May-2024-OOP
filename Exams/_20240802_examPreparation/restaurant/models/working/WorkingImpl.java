package Exams._20240802_examPreparation.restaurant.models.working;

import Exams._20240802_examPreparation.restaurant.models.client.Client;
import Exams._20240802_examPreparation.restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working {
    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {

        for (Waiter waiter : waiters) {
            while (waiter.canWork() && client.getClientOrders().iterator().hasNext()) {
                waiter.work();
                String order = client.getClientOrders().iterator().next();
                waiter.takenOrders().getOrdersList().add(order);
                client.getClientOrders().remove(order);
            }
        }
    }
}
