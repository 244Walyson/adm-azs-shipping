package com.waly.azShipMongo.domain.ports;

import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.Ship;

import java.util.List;

public interface ClientPort {

    List<Client> findAll(String param);
    Client findById(String id);
    Client insert(Client client);
    Client update(String id, Client client);
    Client delete(String id);

}
