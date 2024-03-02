package com.waly.azShipMongo.Adapter.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waly.azShipMongo.Adapter.model.embedded.ClientEmbedded;
import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import com.waly.azShipMongo.Adapter.model.entities.ShipEntity;
import com.waly.azShipMongo.Adapter.model.exceptions.DatabaseException;
import com.waly.azShipMongo.Adapter.model.exceptions.ResourceNotFoundException;
import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ShipRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
public class ShipRepositoryAdapter implements ShipRepositoryPort {

    @Autowired
    private ShipRepository repository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Ship> findAll(String param, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ShipEntity> shipEntities = repository.searchShips(param, pageable);
        List<ShipEntity> shipEntityList = shipEntities.getContent();
        return shipEntityList.stream().map(x -> modelMapper.map(x, Ship.class)).toList();
    }

    @Override
    public Ship findById(String id) {
        ShipEntity shipEntity = repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Frete não encontrado para o id: " + id);
        });
        return modelMapper.map(shipEntity, Ship.class);
    }

    @Override
    public Ship insert(Ship ship) {
        ShipEntity entity = modelMapper.map(ship, ShipEntity.class);
        entity.setCreatedAt(Instant.now());
        String clientId = ship.getClient().getId();
        ClientEntity client = clientRepository.findById(clientId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente não encontrado para o id: " + clientId);
        });
        entity.setClient(new ClientEmbedded(client));
        return modelMapper.map(repository.save(entity), Ship.class);
    }

    @Override
    public Ship update(Ship ship) {
        ShipEntity entity = repository.findById(ship.getId()).orElseThrow(() -> {
            throw new ResourceNotFoundException("Frete não encontrado para o id: " + ship.getId());
        });
        Instant instant = entity.getCreatedAt();
        entity.getProperties().clear();
        String clientId = ship.getClient().getId();
        ClientEntity client = clientRepository.findById(clientId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente não encontrado para o id: " + clientId);
        });
        modelMapper.map(ship, entity);
        entity.setClient(new ClientEmbedded(client));
        entity.setCreatedAt(instant);
        return modelMapper.map(repository.save(entity), Ship.class);
    }

    @Override
    public void delete(String id)
    {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Frete não encontrado para o id: " + id);
        }
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
