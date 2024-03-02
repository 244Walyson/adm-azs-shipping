package com.waly.azShipMongo.Adapter.controllers;

import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ShipServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShipController {

    @Autowired
    private ShipServicePort service;

    @SchemaMapping(typeName = "Query", value = "findAllShips")
    public List<Ship> findAll(@Argument String param){
        return service.findAll(param);
    }

    @SchemaMapping(typeName = "Query", value = "shipById")
    public Ship shipById(@Argument String id){
        return service.findById(id);
    }

    @MutationMapping
    public Ship insertShip(@Argument Ship ship){
        return service.insert(ship);
    }

    @MutationMapping
    public Ship updateShip(@Argument Ship ship){
        return service.update(ship);
    }
    @MutationMapping
    public void deleteShip(@Argument String id){
        service.delete(id);
    }
}
