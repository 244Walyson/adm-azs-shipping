package com.waly.azShipMongo.domain.ports;

import com.waly.azShipMongo.domain.Property;

import java.util.List;

public interface PropertyRepositoryPort {

    List<Property> findAll(String param);
    Property findById(String id);
    Property insert(Property property);
    Property update(String id, Property property);
    Property delete(String id);

}
