package com.waly.desafioaz.services;

import com.waly.desafioaz.dtos.PropertyDTO;
import com.waly.desafioaz.dtos.ShipDTO;
import com.waly.desafioaz.entities.*;
import com.waly.desafioaz.exceptions.DatabaseException;
import com.waly.desafioaz.exceptions.ResourceNotFoundException;
import com.waly.desafioaz.repositories.Clientrepository;
import com.waly.desafioaz.repositories.PropertyRepository;
import com.waly.desafioaz.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class ShipService {

    @Autowired
    private ShipRepository repository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private Clientrepository clientrepository;

    @Transactional(readOnly = true)
    public Page<ShipDTO> findAll(String param, Pageable pageable) {
        Page<Ship> ships = repository.findAllByAttributes(param, pageable);
        return ships.map(x -> new ShipDTO(x));
    }

    @Transactional(readOnly = true)
    public ShipDTO findById(Long id) {
        Ship ship = repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Frete não encontrado para o id: " + id);
        });
        return new ShipDTO(ship);
    }

    @Transactional(readOnly = false)
    public ShipDTO update(Long id, ShipDTO dto) {
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Frete não encontrado para o id: " + id);
        }
        Ship ship = repository.getReferenceById(id);
        Instant created = ship.getCreatedAt();
        ship = copyDtoToEntity(dto);
        ship.setId(id);
        ship.setCreatedAt(created);
        ship = repository.save(ship);
        return new ShipDTO(ship);
    }

    @Transactional(readOnly = false)
    public ShipDTO insert(ShipDTO dto) {
        Ship ship = copyDtoToEntity(dto);
        ship = repository.save(ship);
        return new ShipDTO(ship);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Frete não encontrado para o id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private Ship copyDtoToEntity(ShipDTO dto) {
        Ship ship = new Ship();
        ship.setDescription(dto.getDescription());

        Client client = clientrepository.getReferenceById(dto.getClient().getId());
        ship.setClient(client);

        for (PropertyDTO propertyDTO : dto.getProperties()) {
            Property property = copyPropertyToEntity(propertyDTO);
            property.setShip(ship);
            ship.setProperty(propertyRepository.save(property));
        }
        return ship;
    }

    private Property copyPropertyToEntity(PropertyDTO dto){
        Property property = new Property();
        property.setName(dto.getName());
        property.setPropertyValue(dto.getPropertyValue());
        return property;
    }
}
