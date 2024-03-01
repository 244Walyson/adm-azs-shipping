package com.waly.desafioaz.dtos;

import com.waly.desafioaz.entities.Client;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientShipDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cnpj;
    private Set<ShipMinDTO> ships = new HashSet<>();

    public ClientShipDTO() {
    }

    public ClientShipDTO(Long id, String name, String email, String phone, String cnpj, Set<ShipMinDTO> ships) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
        this.ships = ships;
    }

    public ClientShipDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.cnpj = client.getCnpj();
        this.ships = client.getShips().stream().map(x -> new ShipMinDTO(x)).collect(Collectors.toSet());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Set<ShipMinDTO> getShips() {
        return ships;
    }

    public void setShips(Set<ShipMinDTO> ships) {
        this.ships = ships;
    }
}
