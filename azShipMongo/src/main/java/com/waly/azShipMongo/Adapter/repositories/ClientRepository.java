package com.waly.azShipMongo.Adapter.repositories;

import com.waly.azShipMongo.Adapter.entities.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
