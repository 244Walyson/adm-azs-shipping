package com.waly.azShipMongo.domain.services;

import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ShipPort;
import com.waly.azShipMongo.domain.ports.ShipServicePort;

import java.util.List;

public class ShipService implements ShipServicePort {

    private final ShipPort shipPort;

    public ShipService(ShipPort shipPort) {
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
    public Ship update(String id, Ship ship) {
        return shipPort.update(id, ship);
    }

    @Override
    public Ship delete(String id) {
        return shipPort.delete(id);
    }
}
