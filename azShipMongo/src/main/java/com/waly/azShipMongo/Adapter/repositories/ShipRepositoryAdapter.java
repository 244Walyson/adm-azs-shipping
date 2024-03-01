package com.waly.azShipMongo.Adapter.repositories;

import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ShipRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipRepositoryAdapter implements ShipRepositoryPort {

    @Autowired
    private ShipRepository repository;

    @Override
    public List<Ship> findAll(String param) {
        return null;
    }

    @Override
    public Ship findById(String id) {
        return null;
    }

    @Override
    public Ship insert(Ship ship) {
        return null;
    }

    @Override
    public Ship update(String id, Ship ship) {
        return null;
    }

    @Override
    public Ship delete(String id) {
        return null;
    }
}
