package com.waly.azShipMongo.Adapter.repositories;

import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity, String> {


    @Query("{ $or: [ { 'name': { $regex: ?0, $options: 'i' } }, " +
            "{ 'email': { $regex: ?0, $options: 'i' } }, " +
            "{ 'phone': { $regex: ?0, $options: 'i' } }, " +
            "{ 'cnpj': { $regex: ?0, $options: 'i' } } ] }")
    Page<ClientEntity> findAllByParam(String param, Pageable pageable);
}
