package Exams._20240802_examPreparation.restaurant.models.working;

import Exams._20240802_examPreparation.restaurant.models.client.Client;
import Exams._20240802_examPreparation.restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Working {
    void takingOrders(Client client, Collection<Waiter> waiters);

}
