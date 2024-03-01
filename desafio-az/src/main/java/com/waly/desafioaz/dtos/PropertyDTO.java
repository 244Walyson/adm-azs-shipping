package com.waly.desafioaz.dtos;

import com.waly.desafioaz.entities.Property;

public class PropertyDTO {

    private Long id;
    private String name;
    private Double propertyValue;


    public PropertyDTO() {
    }

    public PropertyDTO(Property property) {
        this.id = property.getId();
        this.name = property.getName();
        this.propertyValue = property.getPropertyValue();
    }

    public PropertyDTO(Long id, String name, String type, Double propertyValue) {
        this.id = id;
        this.name = name;
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

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }
}
