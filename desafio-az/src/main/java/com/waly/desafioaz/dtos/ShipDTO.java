package com.waly.desafioaz.dtos;


import com.waly.desafioaz.entities.Ship;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ShipDTO {

    private Long id;
    private ClientDTO client;
    private Instant createdAt;
    private String description;
    private Set<PropertyDTO> properties = new HashSet<>();


    public ShipDTO() {
    }

    public ShipDTO(Ship ship) {
        this.id = ship.getId();
        this.createdAt = ship.getCreatedAt();
        this.description = ship.getDescription();
        this.client = new ClientDTO(ship.getClient());
        this.properties = ship.getProperties().stream().map(x -> new PropertyDTO(x)).collect(Collectors.toSet());
    }

    public ShipDTO(Long id, Instant createdAt, String description, Set<PropertyDTO> properties) {
        this.id = id;
        this.createdAt = createdAt;
        this.description = description;
        this.properties = properties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(Set<PropertyDTO> properties) {
        this.properties = properties;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
