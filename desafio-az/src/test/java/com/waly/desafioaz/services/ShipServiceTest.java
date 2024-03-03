package com.waly.desafioaz.services;

import com.waly.desafioaz.dtos.ShipDTO;
import com.waly.desafioaz.entities.Client;
import com.waly.desafioaz.entities.Property;
import com.waly.desafioaz.entities.Ship;
import com.waly.desafioaz.exceptions.ResourceNotFoundException;
import com.waly.desafioaz.repositories.Clientrepository;
import com.waly.desafioaz.repositories.PropertyRepository;
import com.waly.desafioaz.repositories.ShipRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ShipServiceTest {

    @InjectMocks
    private ShipService service;
    @Mock
    private ShipRepository repository;
    @Mock
    private Clientrepository clientrepository;
    @Mock
    private PropertyRepository propertyRepository;
    private Long existingId, nonExistingId;
    private Ship ship;
    private Client client;
    private Property property;
    private ShipDTO dto;
    private PageImpl<Ship> page;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 100L;
        property = new Property(1L, "peso", null, 2000.00);
        client = new Client(1L, "new client", "new@gmail.com", "3252454252", "352345425", null);
        ship = new Ship(existingId, null, "novo frete", List.of(property));
        ship.setClient(client);
        dto = new ShipDTO(ship);
        page = new PageImpl<>(List.of(ship));

        Mockito.doNothing().when(repository).deleteById(existingId);
        Mockito.when(repository.existsById(existingId)).thenReturn(true);
        Mockito.when(repository.existsById(nonExistingId)).thenReturn(false);
        Mockito.when(repository.findAllByAttributes(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(page);
        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(ship));
        Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(ship);
    }


    @Test
    public void findAllShouldReturnPageOfShips() {
        Pageable pageable = PageRequest.of(0,10);
        Page<ShipDTO> result = service.findAll("", pageable);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(ship.getId(), result.getContent().get(0).getId());
        Mockito.verify(repository, Mockito.times(1)).findAllByAttributes("", pageable);
    }

    @Test
    public void insertShouldReturnShipDtoWhenValidData() {
        ShipDTO result = service.insert(dto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getDescription(), "novo frete");
        Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any());
    }

    @Test
    public void updateShouldReturnShipDtoWhenValidData(){
        ShipDTO result = service.update(existingId, dto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getDescription(), "novo frete");
        Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
    @Test
    public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists(){
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingId, dto);
        });
    }
    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });
        Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(nonExistingId);
        });
        Mockito.verify(repository, Mockito.times(1)).existsById(nonExistingId);
    }

}
