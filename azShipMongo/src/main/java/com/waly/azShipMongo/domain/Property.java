package com.waly.azShipMongo.domain;
public class Property {

    private String name;
    private Double value;

    public Property() {
    }

    public Property(String name, Double propertyValue) {
        this.name = name;
        this.value = propertyValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
