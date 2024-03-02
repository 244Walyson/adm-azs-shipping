package com.waly.azShipMongo.domain.ports;

import com.waly.azShipMongo.domain.Client;

import java.util.List;

public interface ClientServicePort {

    List<Client> findAll(String param);
    Client findById(String id);
    Client insert(Client client);
    Client update(Client client);
    void delete(String id);

}
