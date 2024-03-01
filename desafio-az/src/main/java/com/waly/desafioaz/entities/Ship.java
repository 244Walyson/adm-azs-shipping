package com.waly.desafioaz.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
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
    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
    private Set<Property> properties = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Ship() {
    }

    public Ship(Long id, Instant createdAt, String description, Set<Property> properties) {
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

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public void setProperty(Property property){
        properties.add(property);
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

    public void setClient(Client client) {
        this.client = client;
    }
}
