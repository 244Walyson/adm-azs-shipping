package com.waly.azShipMongo.domain.services;

import com.waly.azShipMongo.domain.Property;
import com.waly.azShipMongo.domain.ports.PropertyRepositoryPort;
import com.waly.azShipMongo.domain.ports.PropertyServicePort;

import java.util.List;

public class PropertyService implements PropertyServicePort {

    private final PropertyRepositoryPort propertyPort;

    public PropertyService(PropertyRepositoryPort propertyPort) {
        this.propertyPort = propertyPort;
    }

    @Override
    public List<Property> findAll(String param) {
        return propertyPort.findAll(param);
    }

    @Override
    public Property findById(String id) {
        return propertyPort.findById(id);
    }

    @Override
    public Property insert(Property property) {
        return propertyPort.insert(property);
    }

    @Override
    public Property update(Property property) {
        return propertyPort.update(property);
    }

    @Override
    public void delete(String id) {
        propertyPort.delete(id);
    }
}
