package com.waly.azShipMongo.domain.ports;

import com.waly.azShipMongo.domain.Ship;

import java.util.List;

public interface ShipServicePort {

    List<Ship> findAll(String param);
    Ship findById(String id);
    Ship insert(Ship ship);
    Ship update(String id, Ship ship);
    Ship delete(String id);

}
