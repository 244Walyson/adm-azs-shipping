package com.waly.azShipMongo.domain.ports;

import com.waly.azShipMongo.domain.Ship;

import java.util.List;

public interface ShipRepositoryPort {

    List<Ship> findAll(String param, int page, int pageSize);
    Ship findById(String id);
    Ship insert(Ship ship);
    Ship update(Ship ship);

    void delete(String id);

}
