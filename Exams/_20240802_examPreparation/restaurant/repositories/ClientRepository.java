package Exams._20240802_examPreparation.restaurant.repositories;

import Exams._20240802_examPreparation.restaurant.models.client.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClientRepository implements Repository<Client> {
    Collection<Client> clients;

    public ClientRepository() {
        clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(clients);
    }

    @Override
    public void add(Client entity) {
        clients.add(entity);
    }

    @Override
    public boolean remove(Client entity) {
        return clients.remove(entity);
    }

    @Override
    public Client byName(String name) {
        return clients.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
