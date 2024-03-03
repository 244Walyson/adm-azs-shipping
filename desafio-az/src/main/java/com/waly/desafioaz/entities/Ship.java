package com.waly.desafioaz.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_ship")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant createdAt;
    private String description;
    private ShipStatus status;
    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Ship() {
    }

    public Ship(Long id, Instant createdAt, String description, List<Property> properties) {
        this.id = id;
        this.createdAt = createdAt;
        this.description = description;
        this.properties = properties;
    }



    @PrePersist
    private  void setCreatedAt(){
        this.createdAt = Instant.now();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setProperty(Property property){
        properties.add(property);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
