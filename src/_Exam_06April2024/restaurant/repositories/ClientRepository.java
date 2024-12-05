package _Exam_06April2024.restaurant.repositories;

import _Exam_06April2024.restaurant.models.client.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClientRepository implements Repository<Client>{
    private Collection<Client> clients;
    public ClientRepository(){
        this.clients = new ArrayList<>();
    }
    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(this.clients);
    }

    @Override
    public void add(Client client) {
        this.clients.add(client);
    }

    @Override
    public boolean remove(Client client) {
        if (this.clients.contains(client)){
            this.clients.remove(client);
            return true;
        }
        return false;
    }

    @Override
    public Client byName(String name) {
        return this.clients.stream()
                .filter(client -> client.getName().equals(name))
                .findFirst().orElse(null);
    }
}
