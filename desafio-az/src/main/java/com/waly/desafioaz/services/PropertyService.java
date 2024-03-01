package com.waly.desafioaz.services;

import com.waly.desafioaz.dtos.PropertyDTO;
import com.waly.desafioaz.entities.Property;
import com.waly.desafioaz.exceptions.DatabaseException;
import com.waly.desafioaz.exceptions.ResourceNotFoundException;
import com.waly.desafioaz.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    @Transactional(readOnly = true)
    public PropertyDTO findById(Long id){
        Property property = repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Propiedade não encontrada para o id: " + id);
        });
        return new PropertyDTO(property);
    }

    @Transactional(readOnly = true)
    public List<PropertyDTO> findAll(){
        return repository.findAll().stream().map(x -> new PropertyDTO(x)).toList();
    }

    @Transactional(readOnly = false)
    public PropertyDTO insert(PropertyDTO dto){
        Property property = copyDtoToEntity(dto);
        property = repository.save(property);
        return new PropertyDTO(property);
    }

    @Transactional(readOnly = false)
    public PropertyDTO update(Long id, PropertyDTO dto){
        Property property = copyDtoToEntity(dto);
        property = repository.save(property);
        return new PropertyDTO(property);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Propiedade não encontrada para o id: " + id);
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private Property copyDtoToEntity(PropertyDTO dto) {
        Property property = new Property();
        property.setId(dto.getId());
        property.setName(dto.getName());
        return property;
    }
}
