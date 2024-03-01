package com.waly.azShipMongo.domain.services;

import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.ports.ClientRepositoryPort;
import com.waly.azShipMongo.domain.ports.ClientServicePort;

import java.util.List;

public class ClientService implements ClientServicePort {

    private final ClientRepositoryPort clientPort;

    public ClientService(ClientRepositoryPort clientPort) {
        this.clientPort = clientPort;
    }


    @Override
    public List<Client> findAll(String param) {
        return clientPort.findAll(param);
    }

    @Override
    public Client findById(String id) {
        return clientPort.findById(id);
    }

    @Override
    public Client insert(Client client) {
        return clientPort.insert(client);
    }

    @Override
    public Client update(String id, Client client) {
        return clientPort.update(id, client);
    }

    @Override
    public Client delete(String id) {
        return clientPort.delete(id);
    }
}
