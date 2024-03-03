package com.waly.desafioaz.dtos;

import com.waly.desafioaz.entities.Property;

public class PropertyDTO {

    private String name;
    private Double propertyValue;


    public PropertyDTO() {
    }

    public PropertyDTO(Property property) {
        this.name = property.getName();
        this.propertyValue = property.getPropertyValue();
    }

    public PropertyDTO(String name, Double propertyValue) {
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
