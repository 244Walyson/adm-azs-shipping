package com.waly.desafioaz.dtos;

import com.waly.desafioaz.entities.Ship;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ShipMinDTO {

    private Long id;
    private Instant createdAt;
    private String description;
    private Set<PropertyDTO> properties = new HashSet<>();


    public ShipMinDTO() {
    }

    public ShipMinDTO(Ship ship) {
        this.id = ship.getId();
        this.createdAt = ship.getCreatedAt();
        this.description = ship.getDescription();
        this.properties = ship.getProperties().stream().map(x -> new PropertyDTO(x)).collect(Collectors.toSet());
    }

    public ShipMinDTO(Long id, Instant createdAt, String description, Set<PropertyDTO> properties) {
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

}
