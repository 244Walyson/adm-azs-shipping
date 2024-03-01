package com.waly.desafioaz.services;

import com.waly.desafioaz.dtos.ClientDTO;
import com.waly.desafioaz.dtos.ClientShipDTO;
import com.waly.desafioaz.dtos.PropertyDTO;
import com.waly.desafioaz.dtos.ShipDTO;
import com.waly.desafioaz.entities.Client;
import com.waly.desafioaz.entities.Property;
import com.waly.desafioaz.entities.Ship;
import com.waly.desafioaz.exceptions.DatabaseException;
import com.waly.desafioaz.exceptions.ResourceNotFoundException;
import com.waly.desafioaz.repositories.Clientrepository;
import com.waly.desafioaz.repositories.PropertyRepository;
import com.waly.desafioaz.repositories.ShipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ClientService {

    @Autowired
    private Clientrepository repository;

    @Transactional(readOnly = true)
    public Page<ClientShipDTO> findAll(String param, Pageable pageable) {
        Page<Client> ships = repository.findAllByParam(param, pageable);
        return ships.map(x -> new ClientShipDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientShipDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Cliente não encontrado para o id: " + id);
        });
        return new ClientShipDTO(client);
    }

    @Transactional(readOnly = false)
    public ClientDTO update(Long id, ClientDTO dto) {
        Client client = repository.getReferenceById(id);
        client = copyDtoToEntity(dto);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional(readOnly = false)
    public ClientDTO insert(ClientDTO dto) {
        Client client = copyDtoToEntity(dto);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado para o id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private Client copyDtoToEntity(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());
        client.setCnpj(dto.getCnpj());
        return client;
    }
}
