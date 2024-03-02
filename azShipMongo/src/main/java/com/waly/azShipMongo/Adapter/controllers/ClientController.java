package com.waly.azShipMongo.Adapter.controllers;

import com.waly.azShipMongo.Adapter.model.dto.ReqStatus;
import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.CustomPage;
import com.waly.azShipMongo.domain.ports.ClientServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

    @Autowired
    private ClientServicePort service;


    @QueryMapping
    public CustomPage<Client> findAllClients(@Argument String param, @Argument Integer page, @Argument Integer pageSize){
        if (param == null){ param = ""; };
        if(page == null){ page = 0; };
        if(pageSize == null){pageSize = 10; };

        return service.findAll(param, page, pageSize);
    }

    @QueryMapping
    public Client findClientById(@Argument String id){
        return service.findById(id);
    }

    @MutationMapping
    public Client insertClient(@Argument Client client){
        return service.insert(client);
    }

    @MutationMapping
    public Client updateClient(@Argument Client client){
        return service.insert(client);
    }

    @MutationMapping
    public ReqStatus deleteClient(@Argument String id){
        service.delete(id);
        return new ReqStatus(HttpStatus.NO_CONTENT.value());
    }
}
