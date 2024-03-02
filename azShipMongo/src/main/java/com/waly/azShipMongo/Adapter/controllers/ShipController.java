package com.waly.azShipMongo.Adapter.controllers;

import com.waly.azShipMongo.Adapter.model.dto.ReqStatus;
import com.waly.azShipMongo.Adapter.repositories.ShipRepositoryAdapter;
import com.waly.azShipMongo.domain.CustomPage;
import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ShipRepositoryPort;
import com.waly.azShipMongo.domain.ports.ShipServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShipController {

    @Autowired
    private ShipServicePort service;
    @SchemaMapping(typeName = "Query", value = "findAllShips")
    public CustomPage<Ship> findAll(@Argument String param, @Argument Integer page, @Argument Integer pageSize){
        if(param == null){
            param = "";
        }
        if (page == null){
            page = 0;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        return service.findAll(param, page, pageSize);
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
    public ReqStatus deleteShip(@Argument String id){
        service.delete(id);
        return new ReqStatus(HttpStatus.NO_CONTENT.value());
    }
}
