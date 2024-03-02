package com.waly.azShipMongo.domain.ports;

import com.waly.azShipMongo.domain.Property;

import java.util.List;

public interface PropertyServicePort {

    List<Property> findAll(String param);
    Property findById(String id);
    Property insert(Property property);
    Property update(Property property);
    void delete(String id);

}
