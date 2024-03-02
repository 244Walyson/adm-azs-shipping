package com.waly.azShipMongo.Adapter.repositories;

import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.ports.ClientRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    @Autowired
    private ClientRepository repository;

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
    public Client update(Client client) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
