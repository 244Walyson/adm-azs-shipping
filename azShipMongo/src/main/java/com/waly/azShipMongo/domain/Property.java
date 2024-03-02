package com.waly.azShipMongo.domain;
public class Property {

    private String name;
    private Double propertyValue;

    public Property() {
    }

    public Property(String name, Double propertyValue) {
        this.name = name;
        this.propertyValue = propertyValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }
}
