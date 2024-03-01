package com.waly.azShipMongo.domain;
public class Property {

    private Long id;
    private String name;
    private Ship ship;
    private Double propertyValue;

    public Property() {
    }

    public Property(Long id, String name, Ship ship, Double propertyValue) {
        this.id = id;
        this.name = name;
        this.ship = ship;
        this.propertyValue = propertyValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }
}
