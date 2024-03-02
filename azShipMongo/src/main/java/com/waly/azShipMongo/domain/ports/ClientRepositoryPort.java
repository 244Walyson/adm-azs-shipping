package com.waly.azShipMongo.domain.ports;

import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.CustomPage;

import java.util.List;

public interface ClientRepositoryPort {

    CustomPage<Client> findAll(String param, int page, int pageSize);
    Client findById(String id);
    Client insert(Client client);
    Client update(Client client);
    void delete(String id);

}
