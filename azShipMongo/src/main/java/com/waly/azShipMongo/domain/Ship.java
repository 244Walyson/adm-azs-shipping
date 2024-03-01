package com.waly.azShipMongo.domain;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Ship {

    private Long id;
    private Instant createdAt;
    private String description;
    private ShipStatus status;
    private Set<Property> properties = new HashSet<>();
    private Client client;

    public Ship() {
    }

    public Ship(Long id, Instant createdAt, String description, ShipStatus status, Set<Property> properties, Client client) {
        this.id = id;
        this.createdAt = createdAt;
        this.description = description;
        this.status = status;
        this.properties = properties;
        this.client = client;
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

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
