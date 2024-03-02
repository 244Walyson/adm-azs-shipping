package com.waly.azShipMongo.domain.services;

import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ShipRepositoryPort;
import com.waly.azShipMongo.domain.ports.ShipServicePort;

import java.util.List;

public class ShipService implements ShipServicePort {

    private final ShipRepositoryPort shipPort;

    public ShipService(ShipRepositoryPort shipPort) {
        this.shipPort = shipPort;
    }

    @Override
    public List<Ship> findAll(String param) {
        return shipPort.findAll(param);
    }

    @Override
    public Ship findById(String id) {
        return shipPort.findById(id);
    }

    @Override
    public Ship insert(Ship ship) {
        return shipPort.insert(ship);
    }

    @Override
    public Ship update(Ship ship) {
        return shipPort.update(ship);
    }

    @Override
    public void delete(String id) {
        shipPort.delete(id);
    }
}
