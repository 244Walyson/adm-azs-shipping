package com.waly.azShipMongo.Adapter.repositories;

import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import com.waly.azShipMongo.Adapter.model.entities.ShipEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends MongoRepository<ShipEntity, String> {

    @Query("{ $or: [ " +
            "{ 'description': { $regex: ?0, $options: 'i' } }, " +
            "{ 'status': { $regex: ?0, $options: 'i' } }, " +
            "{ 'client.name': { $regex: ?0, $options: 'i' } }, " +
            "{ 'client.cnpj': { $regex: ?0, $options: 'i' } }, " +
            "{ 'client.email': { $regex: ?0, $options: 'i' } }, " +
            "{ 'client.phone': { $regex: ?0, $options: 'i' } }, " +
            "{ 'properties.name': { $regex: ?0, $options: 'i' } } " +
            "] }")
    Page<ShipEntity> searchShips(String query, Pageable pageable);

}
