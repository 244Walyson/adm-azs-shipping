package com.waly.azShipMongo.Adapter.repositories;

import com.waly.azShipMongo.Adapter.model.embedded.ClientEmbedded;
import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import com.waly.azShipMongo.Adapter.model.entities.ShipEntity;
import com.waly.azShipMongo.domain.Client;
import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ShipRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ShipRepositoryAdapter implements ShipRepositoryPort {

    @Autowired
    private ShipRepository repository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Ship> findAll(String param) {
        List<ShipEntity> shipEntities = repository.findAll();
        return shipEntities.stream().map(x -> modelMapper.map(x, Ship.class)).toList();
    }

    @Override
    public Ship findById(String id) {
        ShipEntity shipEntity = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("");
        });
        return modelMapper.map(shipEntity, Ship.class);
    }

    @Override
    public Ship insert(Ship ship) {
        ShipEntity entity = modelMapper.map(ship, ShipEntity.class);
        entity.setCreatedAt(Instant.now());
        ClientEntity client = clientRepository.findById(ship.getClient().getId()).orElseThrow(() -> {
            throw new RuntimeException("");
        });
        entity.setClient(new ClientEmbedded(client));
        return modelMapper.map(repository.save(entity), Ship.class);
    }

    @Override
    public Ship update(Ship ship) {
        ShipEntity entity = repository.findById(ship.getId()).orElseThrow(() -> {
            throw new RuntimeException("");
        });
        Instant instant = entity.getCreatedAt();
        entity.getProperties().clear();
        ClientEntity client = clientRepository.findById(ship.getClient().getId()).orElseThrow(() -> {
            throw new RuntimeException("");
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
            throw new RuntimeException();
        }
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }
}
