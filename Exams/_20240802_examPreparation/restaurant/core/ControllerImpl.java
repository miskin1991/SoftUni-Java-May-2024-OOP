package Exams._20240802_examPreparation.restaurant.core;

import Exams._20240802_examPreparation.restaurant.models.client.Client;
import Exams._20240802_examPreparation.restaurant.models.client.ClientImpl;
import Exams._20240802_examPreparation.restaurant.models.waiter.FullTimeWaiter;
import Exams._20240802_examPreparation.restaurant.models.waiter.HalfTimeWaiter;
import Exams._20240802_examPreparation.restaurant.models.waiter.Waiter;
import Exams._20240802_examPreparation.restaurant.models.working.Working;
import Exams._20240802_examPreparation.restaurant.models.working.WorkingImpl;
import Exams._20240802_examPreparation.restaurant.repositories.ClientRepository;
import Exams._20240802_examPreparation.restaurant.repositories.WaiterRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static Exams._20240802_examPreparation.restaurant.common.ConstantMessages.*;
import static Exams._20240802_examPreparation.restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private WaiterRepository waiterRepository;
    private ClientRepository clientRepository;
    private Working working;
    private int totalCountOfServedClients;

    public ControllerImpl() {
        waiterRepository = new WaiterRepository();
        clientRepository = new ClientRepository();
        working = new WorkingImpl();
        totalCountOfServedClients = 0;

    }

    @Override
    public String addWaiter(String type, String waiterName) {
        switch (type) {
            case "FullTimeWaiter": {
                waiterRepository.add(new FullTimeWaiter(waiterName));
                break;
            }
            case "HalfTimeWaiter": {
                waiterRepository.add(new HalfTimeWaiter(waiterName));
                break;
            }
            default:
                throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }
        return WAITER_ADDED.formatted(type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        ClientImpl client = new ClientImpl(clientName);
        client.getClientOrders().addAll(List.of(orders));
        clientRepository.add(client);
        return CLIENT_ADDED.formatted(clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiterRepository.byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(WAITER_DOES_NOT_EXIST.formatted(waiterName));
        }
        waiterRepository.remove(waiter);
        return WAITER_REMOVE.formatted(waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = clientRepository.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(CLIENT_DOES_NOT_EXIST.formatted(clientName));
        }
        clientRepository.remove(client);
        return CLIENT_REMOVE.formatted(clientName);
    }

    @Override
    public String startWorking(String clientName) {
        List<Waiter> waiters = waiterRepository.getCollection()
                .stream()
                .filter(Waiter::canWork)
                .toList();
        if (waiters.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        else {
            working.takingOrders(clientRepository.byName(clientName), waiters);
        }
        totalCountOfServedClients++;
        return ORDERS_SERVING.formatted(clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        String firstRow = FINAL_CLIENTS_COUNT.formatted(totalCountOfServedClients);
        sb.append(firstRow).append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());

        for (Waiter waiter : waiterRepository.getCollection()) {
            sb.append(FINAL_WAITER_NAME.formatted(waiter.getName())).append(System.lineSeparator());
            sb.append(FINAL_WAITER_EFFICIENCY.formatted(waiter.getEfficiency())).append(System.lineSeparator());
            String orders = "None";
            if (!waiter.takenOrders().getOrdersList().isEmpty()) {
                orders = String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList());
            }
            sb.append(FINAL_WAITER_ORDERS.formatted(orders)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
