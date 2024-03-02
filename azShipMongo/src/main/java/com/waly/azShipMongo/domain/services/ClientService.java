package com.waly.azShipMongo.domain.services;

import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.CustomPage;
import com.waly.azShipMongo.domain.ports.ClientRepositoryPort;
import com.waly.azShipMongo.domain.ports.ClientServicePort;

import java.util.List;

public class ClientService implements ClientServicePort {

    private final ClientRepositoryPort clientPort;

    public ClientService(ClientRepositoryPort clientPort) {
        this.clientPort = clientPort;
    }


    @Override
    public CustomPage<Client> findAll(String param, int page, int pageSize) {
        return clientPort.findAll(param, page, pageSize);
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
    public Client update(Client client) {
        return clientPort.update(client);
    }

    @Override
    public void delete(String id) {
        clientPort.delete(id);
    }
}
