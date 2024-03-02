package com.waly.azShipMongo.Adapter.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import com.waly.azShipMongo.Adapter.model.entities.ShipEntity;
import com.waly.azShipMongo.Adapter.model.exceptions.DatabaseException;
import com.waly.azShipMongo.Adapter.model.exceptions.ResourceNotFoundException;
import com.waly.azShipMongo.Adapter.model.exceptions.ValidateException;
import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.CustomPage;
import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ClientRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomPage<Client> findAll(String param, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ClientEntity> clientEntities = repository.findAllByParam(param, pageable);
        clientEntities.stream().map(x -> modelMapper.map(x, Ship.class));
        return modelMapper.map(clientEntities, CustomPage.class);
    }

    @Override
    public Client findById(String id) {
        ClientEntity client =  repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente não encontrado para o id: " + id);
        });
        return modelMapper.map(client, Client.class);
    }

    @Override
    public Client insert(Client client) {
        ClientEntity entity = modelMapper.map(client, ClientEntity.class);
        entity = repository.save(entity);
        return modelMapper.map(entity, Client.class);
    }

    @Override
    public Client update(Client client) {
        ClientEntity entity = repository.findById(client.getId()).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente não encontrado para o id: " + client.getId());
        });
        modelMapper.map(client, entity);
        entity = repository.save(entity);
        return modelMapper.map(entity, Client.class);
    }

    @Override
    public void delete(String id) {
        if(!repository.existsById(id)){
            throw new ValidateException("Cliente não encontrado para o id: " + id);
        }
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
