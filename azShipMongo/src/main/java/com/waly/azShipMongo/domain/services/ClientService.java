package com.waly.azShipMongo.domain.services;

import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.ports.ClientPort;
import com.waly.azShipMongo.domain.ports.ClientServicePort;

import java.util.List;

public class ClientService implements ClientServicePort {

    private final ClientPort clientPort;

    public ClientService(ClientPort clientPort) {
        this.clientPort = clientPort;
    }


    @Override
    public List<Client> findAll(String param) {
        return null;
    }

    @Override
    public Client findById(String id) {
        return null;
    }

    @Override
    public Client insert(Client client) {
        return null;
    }

    @Override
    public Client update(String id, Client client) {
        return null;
    }

    @Override
    public Client delete(String id) {
        return null;
    }
}
