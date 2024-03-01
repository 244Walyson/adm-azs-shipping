package com.waly.azShipMongo.Adapter.repositories;

import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
